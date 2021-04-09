// Creating Variable Handles
public class VariableHandlesUnitTest {
    public int publicTestVariable = 1;
    private int privateTestVariable = 1;
    public int variableToSet = 1;
    public int variableToCompareAndSet = 1;
    public int variableToGetAndAdd = 0;
    public byte variableToBitwiseOr = 0;
}

// Variable Handles for Public Variables Now we can get a VarHandle for our
// publicTestVariable using the findVarHandle() method:

VarHandle PUBLIC_TEST_VARIABLE = MethodHandles
    .lookup()
    .in(VariableHandlesUnitTest.class)
    .findVarHandle(VariableHandlesUnitTest.class, "publicTestVariable", int.class);

// Variable Handles for Private Variables

VarHandle PRIVATE_TEST_VARIABLE = MethodHandles
    .privateLookupIn(VariableHandlesUnitTest.class, MethodHandles.lookup())
    .findVarHandle(VariableHandlesUnitTest.class, "privateTestVariable", int.class);

// Variable Handles for Arrays
VarHandle arrayVarHandle = MethodHandles.arrayElementVarHandle(int[].class);

// Read Access
assertEquals(1, (int) PUBLIC_TEST_VARIABLE.get(this));

// Write Access
VARIABLE_TO_SET.set(this, 15);

// Atomic Update Access
VARIABLE_TO_COMPARE_AND_SET.compareAndSet(this, 1, 100);

// Numeric Atomic Update Access
int before = (int) VARIABLE_TO_GET_AND_ADD.getAndAdd(this, 200);

// Bitwise Atomic Update Access
byte before = (byte) VARIABLE_TO_BITWISE_OR.getAndBitwiseOr(this, (byte) 127);
