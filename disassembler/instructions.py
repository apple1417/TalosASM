from typing import Dict


INSTRUCTIONS: Dict[int, str] = {
    0x00: "nop",
    0x08: "lha a",
    0x09: "sha a",
    0x0A: "lpc a",
    0x0B: "jmp a",
    0x10: "clr a",
    0x11: "mov a",
    0x12: "ldr a",
    0x13: "str a",
    0x18: "add a",
    0x19: "sub a",
    0x20: "inv a",
    0x21: "and a",
    0x22: "orr a",
    0x23: "xor a",
    0x28: "cmz",
    0x29: "cmn",
    0x2A: "ckz a",
    0x2B: "ckn a",
    0x40: "hlt",
    0x48: "lha b",
    0x49: "sha b",
    0x4A: "lpc b",
    0x4B: "jmp b",
    0x50: "clr b",
    0x51: "mov b",
    0x52: "ldr b",
    0x53: "str b",
    0x58: "add b",
    0x59: "sub b",
    0x60: "inv b",
    0x61: "and b",
    0x62: "orr b",
    0x63: "xor b",
    0x68: "tsz",
    0x69: "tsn",
    0x6A: "ckz b",
    0x6B: "ckn b"
}

_2_BIT_IMMEDIATE = {
    0x04: "adi a,",
    0x0C: "sbi a,",
    0x14: "ciz",
    0x1C: "cin",
    0x2C: "ani a,",
    0x34: "ori a,",
    0x3C: "xri a,",
    0x44: "adi b,",
    0x4C: "sbi b,",
    0x54: "tiz",
    0x5C: "tin",
    0x6C: "ani b,",
    0x74: "ori b,",
    0x7C: "xri b,"
}

_4_BIT_IMMEDIATE = {
    0x80: "bis",
    0x90: "jmi",
    0xA0: "lia",
    0xB0: "ldi a,",
    0xC0: "bns",
    0xD0: "hai",
    0xE0: "sia",
    0xF0: "ldi b,"
}

for k, v in _2_BIT_IMMEDIATE.items():
    for i in range(4):
        INSTRUCTIONS[k + i] = f"{v} 0x{i:01X}"

for k, v in _4_BIT_IMMEDIATE.items():
    for i in range(16):
        INSTRUCTIONS[k + i] = f"{v} 0x{i:01X}"
