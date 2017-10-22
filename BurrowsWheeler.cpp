#include <stdexcept> 
#include <string.h>
#include "BinaryStdOut.h"
#include "BinaryStdIn.h"

class BurrowsWheeler {
    public:
    
    
    
    JniMethodInfo t;

    if (JniHelper::getStaticMethodInfo(t,
                                        "BinaryStdIn",
                                         "readString",
                                         "()V")) {
        
        t.env->CallStaticVoidMethod(t.classID, t.methodID);
        
        jstring jstr = (jstring) t.env->CallObjectMethod(t.classID, t.methodID);
        std::string s = JniHelper::jstring2string(jstr);
        t.env->DeleteLocalRef(t.classID);
        }
    
    // apply Burrows-Wheeler encoding, reading from standard input and writing to standard output
    	static void encode()
    	{

    	}

    // apply Burrows-Wheeler decoding, reading from standard input and writing to standard output
    	static void decode()
    	{

    	}
};
int main(int argc, char* argv[])
{
	// if argv[1] is '-', apply Burrows-Wheeler encoding
    // if argv[1] is '+', apply Burrows-Wheeler decoding
    if (argc < 2)
        throw std::invalid_argument("Expected + or - \n");
    else if (strcmp(argv[1], "+") == 0)
        BurrowsWheeler::decode();
    else if (strcmp(argv[1], "-") == 0)
        BurrowsWheeler::encode();
    else
        throw std::invalid_argument("Unknown arguments \n");
}
