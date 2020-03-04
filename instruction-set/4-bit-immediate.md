# 4-Bit Immediate Instructions
All immediates here relate to memory addresses, and thus are treated as unsigned.

## BIS Im : Branch If Set
```
1000iiii : 0x80-8F
```
If the Jump Flag is set, changes the Program Counter to the address specified by the immediate and
the value stored in the High Address register. If the Jump Flag is not set, just increments the
Program Counter.

#### Steps
```
00 : HA Out High, PC Set, PC Clock, IR Bus Im
01 : n/a
```

## BNS Im : Branch Not Set
```
1100iiii : 0xC0-CF
```
If the Jump Flag is *not* set, changes the Program Counter to the address specified by the
immediate and the value stored in the High Address register. If the Jump Flag *is* set, just
increments the program counter.

#### Steps
```
00 : JF Invert Out, HA Out High, PC Set, PC Clock, IR Bus Im
01 : n/a
```

## JMI Im : Jump Immediate
```
1001iiii : 0x90-9F
```
Changes the Program Counter to the address specified by the immediate and the value stored in the
High Address register. Also sets the Jump Flag.

#### Steps
```
00 : JF Set Zero
01 : HA Out High, PC Set, PC Clock, IR Bus Im
```


## HAI Im : High Address Immediate
```
1101iiii : 0xD0-DF
```
Loads the immediate value into the High Address Register.

#### Steps
```
00 : HA Load, IR Bus Im
01 : PC Clock
```

## LIA Im : Load Immediate Address
```
1010iiii : 0xA0-AF
```
Loads the value stored in memory, at the address specified by the immediate and the value stored in
the High Address register, into register A.

#### Steps
```
00 : HA Out High, IR Bus Im, RAM Load Addr
01 : A Load, PC Clock, RAM Out Val
```

## SIA Im : Store Immediate Address
```
1001iiii : 0xE0-EF
```
Stores the value in register A into memory, at the address specified by the immediate and the value
stored in the High Address register.

#### Steps
```
00 : HA Out High, IR Bus Im, RAM Load Addr
01 : A Out, PC Clock, RAM Load Val
```

## LDI A, Im : Load Immediate A
```
1011iiii : 0xB0-BF
```
Loads the immediate value into register A.

#### Steps
```
00 : A Load, IR Bus Im
01 : PC Clock
```

## LDI B, Im : Load Immediate B
```
1111iiii : 0xF0-FF
```
Loads the immediate value into register B.

#### Steps
```
00 : B Load, IR Bus Im
01 : PC Clock
```
