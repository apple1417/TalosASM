# Logical Instructions

## INV A : Invert A
```
00100000 : 0x20
```
Inverts the value stored in register A.

#### Steps
```
00 : ALU Logic Out, OR Load
01 : A Load, OR Out, PC Clock
```

## INV B : Invert B
```
01100000 : 0x60
```
Inverts the value stored in register B.

#### Steps
```
00 : ALU Inv B, ALU Logic Out, OR Load
01 : B Load, OR Out, PC Clock
```

## AND A : AND A
```
00100001 : 0x21
```
Runs a bitwise AND on the values stored in registers A and B, and stores the result in register A.

#### Steps
```
00 : ALU Logic L, ALU Logic Out, OR Load
01 : A Load, OR Out, PC Clock
```

## AND B : AND B
```
01100001 : 0x61
```
Runs a bitwise AND on the values stored in registers A and B, and stores the result in register B.

#### Steps
```
00 : ALU Logic L, ALU Logic Out, OR Load
01 : B Load, OR Out, PC Clock
```

## ORR A : OR A
```
00100010 : 0x22
```
Runs a bitwise OR on the values stored in registers A and B, and stores the result in register A.

#### Steps
```
00 : ALU Logic H, ALU Logic Out, OR Load
01 : A Load, OR Out, PC Clock
```

## ORR B : OR B
```
01100010 : 0x62
```
Runs a bitwise OR on the values stored in registers A and B, and stores the result in register B.

#### Steps
```
00 : ALU Logic H, ALU Logic Out, OR Load
01 : B Load, OR Out, PC Clock
```

## XOR A : XOR A
```
00100011 : 0x23
```
Runs a bitwise XOR on the values stored in registers A and B, and stores the result in register A.

#### Steps
```
00 : ALU Logic H, ALU Logic L, ALU Logic Out, OR Load
01 : A Load, OR Out, PC Clock
```

## XOR B : XOR B
```
01100011 : 0x63
```
Runs a bitwise XOR on the values stored in registers A and B, and stores the result in register B.

#### Steps
```
00 : ALU Logic H, ALU Logic L, ALU Logic Out, OR Load
01 : B Load, OR Out, PC Clock
```
