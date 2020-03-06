# Disassembler
This is a very basic disassembler, created mostly just to verify that code which was manually
converted into hex was done so correctly - it's a lot easier writing this than a compiler.

```
usage: python -m disassembler [-h] [-x] [-n] [-o OUTPUT_FILE] file

positional arguments:
  file

optional arguments:
  -h, --help            show this help message and exit
  -x, --hex-input
  -n, --no-nops
  -o OUTPUT_FILE, --output-file OUTPUT_FILE
```
