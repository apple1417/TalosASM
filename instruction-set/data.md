# Data Instructions

## CLR A : Clear A
```
00010000 : 0x10
```
Sets register A to 0.

#### Steps
```
00 : A Load
01 : PC Clock
```

## CLR B : Clear B
```
01010000 : 0x50
```
Sets register B to 0.

#### Steps
```
00 : B Load
01 : PC Clock
```

## MOV A : Move Into A
```
00010001 : 0x11
```
Moves the value in register B into register A.

#### Steps
```
00 : A Load, B Out
01 : PC Clock
```

## MOV B : Move Into B
```
01010001 : 0x51
```
Moves the value in register A into register B.

#### Steps
```
00 : A Out, B Load
01 : PC Clock
```

## LDR A : Load Register A
```
00010010 : 0x12
```
Loads the value stored in memory, at the address stored in register B, into register A.

#### Steps
```
00 : B Out, RAM Load Addr
01 : A Load, PC Clock, RAM Out Val
```

## LDR B : Load Register B
```
01010010 : 0x52
```
Loads the value stored in memory, at the address stored in register A, into register B.

#### Steps
```
00 : A Out, RAM Load Addr
01 : B Load, PC Clock, RAM Out Val
```

## STR A : Store Register A
```
00010011 : 0x13
```
Stores the value in register A into memory, at the address stored in register B.

#### Steps
```
00 : B Out, RAM Load Addr
01 : A Out, PC Clock, RAM Load Val
```

## STR B : Store Register B
```
01010011 : 0x53
```
Stores the value in register B into memory, at the address stored in register A.

#### Steps
```
00 : A Out, RAM Load Addr
01 : B Out, PC Clock, RAM Load Val
```
