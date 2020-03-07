import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class taloscompsim {

    public static byte A, B, PC, HA = 0;
    public static boolean JF = false;
    public static int instCount = 0;
    public static byte[] RAM = new byte[256];

    public static void main(String args[]){
        try {
            loadMem(new File("collatz.bin"));
        }catch(Exception e){
            System.out.println(e.getMessage());
			System.out.println("You don't have the file there, you hack.");
            System.exit(1);
        }

        //now you just let the program run
        for(int i = 0; i < 1000; i++) {
            //first, execute whatever is at PC
            runInst(RAM[PC]);
            //increment PC
            PC++;
        }

        System.out.println("whoops, this ain't right");
    }

    public static void loadMem(File input) throws IOException {
        byte bytes[] = Files.readAllBytes(Paths.get(input.getAbsolutePath()));
        System.arraycopy(bytes, 0, RAM, 0, bytes.length);
    }

    public static void runInst(byte inst){
        if((inst & 0x80) == 0){
            //next, check for small immediate
            if((inst & 0x4) == 0){
                //statics
                switch(inst){
                    case 0x0: //nop
                        break;
                    case 0x40: //halt
                        System.out.printf("Halted at instruction %d, after %d instructions.",PC,instCount);
                        while(true);
                    case 0x08: //load ha into a
                        A = HA;
                        break;
                    case 0x48: //load ha into B
                        B = HA;
                        break;
                    case 0x09: //store a into ha
                        HA = A;
                        break;
                    case 0x49: //store b into ha
                        HA = B;
                        break;
                    case 0x0A: //load pc into a
                        A = PC;
                        break;
                    case 0x4A: //load pc into b
                        B = PC;
                        break;
                    case 0x0B: //jump to A
                        PC = (byte)(A-1);
                        JF = true;
                        break;
                    case 0x4B: //jump to B
                        PC = (byte)(B-1);
                        JF = true;
                        break;
                    case 0x10: //clr A
                        A = 0;
                        break;
                    case 0x50: //clr B
                        B = 0;
                        break;
                    case 0x11: //mov b to a
                        A = B;
                        break;
                    case 0x51: //mov a to b
                        B = A;
                        break;
                    case 0x12: //load a addr B
                        A = RAM[((int)B + 256)%256];
                        break;
                    case 0x52: //load b addr a
                        B = RAM[((int)A + 256)%256];
                        break;
                    case 0x13: //stor a addr b
                        RAM[B] = A;
                        if(B == 0253) {
                            //this is output, indicate as much
                            System.out.printf("Output FD changed to %x at instruction %d.\n",A,instCount);
                        }else if(B == 254){
                            System.out.printf("Output FE changed to %x at instruction %d.\n",A,instCount);
                        }
                        break;
                    case 0x53: //stor b addr a
                        RAM[A] = B;
                        if(A == 253) {
                            //this is output, indicate as much
                            System.out.printf("Output FD changed to %x at instruction %d.\n",A,instCount);
                        }else if(A == 254){
                            System.out.printf("Output FE changed to %x at instruction %d.\n",A,instCount);
                        }
                        break;
                    case 0x18: // add into a
                        A += B;
                        break;
                    case 0x58: //add into b
                        B += A;
                        break;
                    case 0x19: //sub into A
                        A -= B;
                        break;
                    case 0x59: //sub into B
                        B -= A;
                        break;
                    case 0x20: //inv a
                        A ^= 0xFF;
                        break;
                    case 0x60: //inv b
                        B ^= 0xFF;
                        break;
                    case 0x21: //and into A
                        A &= B;
                        break;
                    case 0x61: //and into B
                        B &= A;
                        break;
                    case 0x22: //or into A
                        A |= B;
                        break;
                    case 0x62: //or into B
                        B |= A;
                        break;
                    case 0x23: //xor into A
                        A ^= B;
                        break;
                    case 0x63: //xor into B
                        B ^= A;
                        break;
                    case 0x28: //compare a to b
                        JF = (A == B);
                        break;
                    case 0x68: //test A&B == 0
                        JF = ((A&B)==0);
                        break;
                    case 0x29: //compare b greater than a
                        JF = (B>A);
                        break;
                    case 0x69: // test high bit for a and b i guess????
                        JF = (A&B&0x80) != 0;
                        break;
                    case 0x2A: //check a is 0
                        JF = A == 0;
                        break;
                    case 0x6A: //check b is 0
                        JF = B == 0;
                        break;
                    case 0x2B: //check a < 0
                        JF = ((A & 0x80) != 0);
                        break;
                    case 0x6B: //check b < 0
                        JF = ((B & 0x80) != 0);
                        break;
                    default: break;
                }
            }else{
                //small immediate
                switch((byte)((inst>>2)&0x3F)){
                    case 0x01: //add immediate to A
                        A += (inst & 0x3);
                        break;
                    case 0x11: //add immediate to B
                        B += (inst & 0x3);
                        break;
                    case 0x03: //sub immediate from A
                        A -= (inst & 0x3);
                        break;
                    case 0x13: //sub immediate from B
                        B -= (inst & 0x3);
                        break;
                    case 0x5: //cmp A to immediate
                        JF = (A == (inst & 0x3));
                        break;
                    case 0x15: //test A and imm
                        JF = ((A&(inst & 0x3))==0);
                        break;
                    case 0x07: //compare a greater than imm
                        JF = A > (inst & 0x3);
                        break;
                    case 0x17: //test less than?? idk
                        JF = false;
                        break;
                    case 0x0B: //and with imm
                        A &= (inst & 0x3);
                        break;
                    case 0x1B: //and with imm
                        B = (byte)(A & (inst & 0x3));
                        break;
                    case 0x0D: //or equals imm
                        A |= (inst & 0x3);
                        break;
                    case 0x1D: //or equals imm
                        B = (byte)(A|(inst & 0x3));
                        break;
                    case 0x0F: //xor equals imm
                        A ^= (inst & 0x3);
                        break;
                    case 0x1F: //xor equals imm
                        B = (byte)(A ^ (inst & 0x3));
                        break;
                    default: break;
                }
            }
        }else{
            //branch/big immediate functions
            byte opcode = (byte)((inst>>4)&0xF);
            switch(opcode){
                case 0x8: //branch if set
                    if(JF){
                        PC = (byte)((HA << 4) + (inst&0xF) - 1);
                    }
                    break;
                case 0xC: //branch if not set
                    if(!JF){
                        PC = (byte)((HA << 4) + (inst&0xF) - 1);
                    }
                    break;
                case 0x9: //jump
                    PC = (byte)((HA << 4) + (inst&0xF) - 1);
                    JF = true;
                    break;
                case 0xD: //load HA IM
                    HA = (byte)(inst&0xF);
                    break;
                case 0xA: //load A addr IM
                    A = RAM[(HA<<4) + (inst&0xF)];
                    break;
                case 0xE: //store A addr IM
                    RAM[(HA<<4) + (inst&0xF)] = A;
                    if((HA<<4) + (inst&0xF) == 253) {
                        //this is output, indicate as much
                        System.out.printf("Output FD changed to %x at instruction %d.\n",A,instCount);
                    }else if((HA<<4) + (inst&0xF) == 254){
                        System.out.printf("Output FE changed to %x at instruction %d.\n",A,instCount);
                    }
                    break;
                case 0xB: // load imm A
                    A = (byte)(inst&0xF);
                    break;
                case 0xF: // load imm B
                    B = (byte)(inst&0xF);
                    break;
                default: break;
            }
        }
        instCount++;
    }

}
