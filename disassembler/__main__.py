import argparse
import re
import struct
import sys
from typing import List, Optional

from .instructions import INSTRUCTIONS


class DissassemblerError(Exception):
    pass


def parse_args(argv: List[str]) -> argparse.Namespace:
    parser = argparse.ArgumentParser("disassembler")
    parser.add_argument("-x", "--hex-input", action="store_true")
    parser.add_argument("-n", "--no-nops", action="store_true")
    parser.add_argument("-o", "--output-file", action="store", default=None)
    parser.add_argument("file", action="store")

    return parser.parse_args(argv)


def main(file: str, hex_input: bool, no_nops: bool, output_file: Optional[str]) -> None:
    program = load_hex_file(file) if hex_input else load_binary_file(file)
    if len(program) > 256:
        raise DissassemblerError(
            f"Program too long! Got {len(program)} bytes but there are only 256 bytes RAM."
        )

    output = ""
    for addr in range(len(program)):
        instr = program[addr]
        if instr == 0x00 and no_nops:
            continue
        output += f"{addr:02X}: "
        if instr in INSTRUCTIONS:
            output += INSTRUCTIONS[instr] + "\n"
        else:
            output += f"0x{instr:02X}\n"

    if output_file is not None:
        try:
            open(output_file, "w").write(output)
        except Exception as e:
            raise DissassemblerError("Error loading from file: " + str(e))
    else:
        print(output)


def load_hex_file(path: str) -> List[int]:
    program = []
    try:
        with open(path) as file:
            for line in file:
                for num in re.split(r"\s*,\s*", line.strip()):
                    if len(num) == 0:
                        continue
                    match = re.fullmatch(r"0x([0-9a-f]{2})", num, flags=re.I)
                    if match is None:
                        raise DissassemblerError(
                            f"Invalid number format: '{num.strip()}' is not a hex value."
                        )
                    program.append(int(match.group(1), 16))
    except Exception as e:
        if isinstance(e, DissassemblerError):
            raise e
        raise DissassemblerError("Error loading from file: " + str(e))
    return program


def load_binary_file(path: str) -> List[int]:
    program: List[int] = []
    try:
        with open(path, "rb") as file:
            while True:
                val = file.read(1)
                if len(val) == 0:
                    return program
                program.append(
                    struct.unpack("B", val)[0]
                )
    except Exception as e:
        raise DissassemblerError("Error loading from file: " + str(e))


if __name__ == "__main__":
    args = parse_args(sys.argv[1:])
    try:
        main(args.file, args.hex_input, args.no_nops, args.output_file)
    except DissassemblerError as e:
        print(f"An error occured:\n{str(e)}", file=sys.stderr)
