# 2-Bit Immediate Instructions
All immediates are treated as unsigned.

## ADI A, Im : Add Immediate A
```
000001ii : 0x04-07
```
Adds the immediate value to the value in register A, and stores the result in register A.

#### Steps
```
00 : ALU Adder Out, OR Load, IR ALU Im
01 : A Load, OR Out, PC Clock
```

## ADI B, Im : Add Immediate B
```
010001ii : 0x44-47
```
Adds the immediate value to the value in register A, and stores the result in register B.

#### Steps
```
00 : ALU Adder Out, OR Load, IR ALU Im
01 : B Load, OR Out, PC Clock
```

## SBI A, Im : Subtract Immediate A
```
000011ii : 0x0C-0F
```
Subtracts the immediate value from the value in register A, and stores the result in register A.

#### Steps
```
00 : ALU Subtract, ALU Adder Out, OR Load, IR ALU Im
01 : A Load, OR Out, PC Clock
```

## SBI B, Im : Subtract Immediate B
```
010011ii : 0x4C-4F
```
Subtracts the immediate value from the value in register A, and stores the result in register B.

#### Steps
```
00 : ALU Subtract, ALU Adder Out, OR Load, IR ALU Im
01 : B Load, OR Out, PC Clock
```

## CIZ Im : Compare Immediate Zero
```
000101ii : 0x14-17
```
Subtracts the immediate value from the value in register A, and sets the Jump Flag if the result
is zero, or clears it if not.

#### Steps
```
00 : ALU Subtract, ALU Adder Out, JF Set Zero, IR ALU Im
01 : PC Clock
```

## TIZ Im : Test Immediate Zero
```
010101ii : 0x54-57
```
Performs a bitwise AND between the value in register A and the immediate, and sets the Jump Flag if
the result is zero, or clears it if not.

#### Steps
```
00 : ALU Logic L, ALU Logic Out, JF Set Zero, IR ALU Im
01 : PC Clock
```

## CIN Im : Compare Immediate Negative
```
000111ii : 0x1C-1F
```
Subtracts the immediate value from the value in register A, and sets the Jump Flag if the result
is negative - i.e. if bit 7 is set - or clears it if not.

#### Steps
```
00 : ALU Subtract, ALU Adder Out, JF Set Neg, IR ALU Im
01 : PC Clock
```

## TIN Im : Test Immediate Negative
```
010111ii : 0x5C-5F
```
Performs a bitwise AND between the value in register A and the immediate, and sets the Jump Flag if
the result is negative - i.e. if bit 7 is set - or clears it if not. In practice, the flag will
always be cleared, no immediate value can ever result in it being set.

#### Steps
```
00 : ALU Logic L, ALU Logic Out, JF Set Neg, IR ALU Im
01 : PC Clock
```

## ANI A, Im : AND Immediate A
```
001011ii : 0x2C-2F
```
Performs a bitwise AND between the value in register A and the immediate, and stores the result in
register A.

#### Steps
```
00 : ALU Logic L, ALU Logic Out, OR Load, IR ALU Im
01 : A Load, OR Out, PC Clock
```

## ANI B, Im : AND Immediate B
```
011011ii : 0x6C-6F
```
Performs a bitwise AND between the value in register A and the immediate, and stores the result in
register B.

#### Steps
```
00 : ALU Logic L, ALU Logic Out, OR Load, IR ALU Im
01 : B Load, OR Out, PC Clock
```

## ORI A, Im : OR Immediate A
```
001101ii : 0x34-37
```
Performs a bitwise OR between the value in register A and the immediate, and stores the result in
register A.

#### Steps
```
00 : ALU Logic H, ALU Logic Out, OR Load, IR ALU Im
01 : A Load, OR Out, PC Clock
```

## ORI B, Im : OR Immediate B
```
011101ii : 0x74-77
```
Performs a bitwise OR between the value in register A and the immediate, and stores the result in
register B.

#### Steps
```
00 : ALU Logic H, ALU Logic Out, OR Load, IR ALU Im
01 : B Load, OR Out, PC Clock
```

## XRI A, Im : XOR Immediate A
```
001111ii : 0x3C-3F
```
Performs a bitwise XOR between the value in register A and the immediate, and stores the result in
register A.

#### Steps
```
00 : ALU Logic H, ALU Logic L, ALU Logic Out, OR Load, IR ALU Im
01 : A Load, OR Out, PC Clock
```

## XRI B, Im : XOR Immediate B
```
011111ii : 0x7C-7F
```
Performs a bitwise XOR between the value in register A and the immediate, and stores the result in
register B.

#### Steps
```
00 : ALU Logic H, ALU Logic L, ALU Logic Out, OR Load, IR ALU Im
01 : B Load, OR Out, PC Clock
```
