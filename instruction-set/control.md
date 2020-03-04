# Control Instructions

## LHA A : Load High Address A
```
00001000 : 0x08
```
Loads the High Address into register A, as the low 4 bits.

#### Steps
```
00 : A Load, HA Out Low
01 : PC Clock
```

## LHA B : Load High Address B
```
01001000 : 0x48
```
Loads the High Address into register B, as the low 4 bits.

#### Steps
```
00 : B Load, HA Out Low
01 : PC Clock
```

## SHA A : Load High Address A
```
00001001 : 0x09
```
Stores the 4 low bits of register A into the High Address register.

#### Steps
```
00 : A Out, HA Load
01 : PC Clock
```

## SHA B : Load High Address B
```
01001001 : 0x49
```
Stores the 4 low bits of register B into the High Address register.

#### Steps
```
00 : B Out, HA Load
01 : PC Clock
```

## LPC A : Load Program Counter A
```
00001010 : 0x0A
```
Loads the current value of the Program Counter into register A. This will be the address of this
instruction, before it is incremented to load the next one.

#### Steps
```
00 : A Load, PC Out
01 : PC Clock
```

## LPC B : Load Program Counter B
```
01001010 : 0x4A
```
Loads the current value of the Program Counter into register B. This will be the address of this
instruction, before it is incremented to load the next one.

#### Steps
```
00 : B Load, PC Out
01 : PC Clock
```

## JMP A : Jump Register A
```
00001011 : 0x0B
```
Stores the current value of register A into the Program Counter. Also sets the Jump Flag.

#### Steps
```
00 : JF Set Zero
01 : A Out, PC Set, PC Clock
```

## JMP B : Jump Register B
```
01001011 : 0x4B
```
Stores the current value of register B into the Program Counter. Also sets the Jump Flag.

#### Steps
```
00 : JF Set Zero
01 : B Out, PC Set, PC Clock
```
