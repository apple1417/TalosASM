# Arithmetic Instructions

## ADD A : Add A
```
00011000 : 0x18
```
Adds the values in registers A and B together and stores the result in register A.

#### Steps
```
00 : ALU Adder Out, OR Load
01 : A Load, OR Out, PC Clock
```

## ADD B : Add B
```
01011000 : 0x58
```
Adds the values in registers A and B together and stores the result in register B.

#### Steps
```
00 : ALU Adder Out, OR Load
01 : B Load, OR Out, PC Clock
```

## SUB A : Subtract A
```
00011001 : 0x19
```
Subtracts the value in register B from the value in register A, and stores the result in
register A.

#### Steps
```
00 : ALU Subtract, ALU Adder Out, OR Load
01 : A Load, OR Out, PC Clock
```

## SUB B : Subtract B
```
01011001 : 0x59
```
Subtracts the value in register B from the value in register A, and stores the result in
register B.

#### Steps
```
00 : ALU Subtract, ALU Adder Out, OR Load
01 : B Load, OR Out, PC Clock
```
