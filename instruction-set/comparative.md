# Comparative Instructions

## CMZ : Compare Zero
```
00101000 : 0x28
```
Subtracts the value in register B from the value in register A, and sets the Jump Flag if the result
is zero, or clears it if not.

#### Steps
```
00 : ALU Subtract, ALU Adder Out, JF Set Zero
01 : PC Clock
```

## TSZ : Test Zero
```
01101000 : 0x68
```
Performs a bitwise AND on the values stored in registers A and B, and sets the Jump Flag if the
result is zero, or clears it if not.

#### Steps
```
00 : ALU Logic L, ALU Logic Out, JF Set Zero
01 : PC Clock
```

## CMN : Compare Negative
```
00101001 : 0x29
```
Subtracts the value in register B from the value in register A, and sets the Jump Flag if the result
is negative - i.e. if bit 7 is set - or clears it if not.

#### Steps
```
00 : ALU Subtract, ALU Adder Out, JF Set Neg
01 : PC Clock
```

## TSN : Test Negative
```
01101001 : 0x69
```
Performs a bitwise AND on the values stored in registers A and B, and sets the Jump Flag if the
result is negative - i.e. if bit 7 is set - or clears it if not.

#### Steps
```
00 : ALU Logic L, ALU Logic Out, JF Set Neg
01 : PC Clock
```

## CKZ A : Check Zero A
```
00101010 : 0x2A
```
Sets the Jump Flag if the value in register A is zero, otherwise clears it.

#### Steps
```
00 : A Out, JF Set Zero
01 : PC Clock
```

## CKZ B : Check Zero B
```
01101010 : 0x6A
```
Sets the Jump Flag if the value in register B is zero, or clears it if not.

#### Steps
```
00 : B Out, JF Set Zero
01 : PC Clock
```

## CKN A : Check Negative A
```
00101011 : 0x2B
```
Sets the Jump Flag if the value in register A is negative - i.e. if bit 7 is set - or clears it if
not.

#### Steps
```
00 : A Out, JF Set Neg
01 : PC Clock
```

## CKN B : Check Negative B
```
01101011 : 0x6B
```
Sets the Jump Flag if the value in register B is negative - i.e. if bit 7 is set - or clears it if
not.

#### Steps
```
00 : B Out, JF Set Neg
01 : PC Clock
```
