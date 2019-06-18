# JUnit

1. Go to libraries in properties, add JUnit to project
2. Click on Test class, right click "Create new Test Case"

Handy functions:

| Function | Result |
| -------- | ------ |
| assertTrue(test) | fails if result is false |
| assertFalse(test) | fails if the boolean test is true |
| assertEquals(expected, actual) | fails if the values are not equal |
| assertEquals(expected, actual, delta) | fails if expected and actual are not within delta of each other |
| assertSame(expected, actual) | fails if the values are not the same (by ==) |
| assertNotSame(expected, actual) | fails if the values are not the same (by !=) |
| assertNull(value) | fails if the given value is not null |
| assertNotNull(value) | fails if the given value is null |
| fail() | fail immediately |

Syntax:

```
class TestTest {
  @Test
  void testAdd() {
    assertEquals(4, 3 + 1);
  }

  @Test
  void testSubtract() {
    assertEquals(4, 16 - 8);
  }
}
```

Can use `@BeforeEach` and `@AfterEach` to do setup / tear down.

**Exceptions:**:

```
@Test
void exceptionTesting() {
  assertThrows(ArithmeticException.class, () -> math.divide(1, 0));
}
```

**Time outs:**

```
@Test timeoutTest() {
  // will be considered a failure if it takes longer than 2 minutes to do
  assertTimeout(
    ofMinutes(2),
    () -> { assertEquals(5, math.add(2, 3)); }
  );
}
```

**Parameterized tests:**

```
// Given two classes MyMath and MyMath2, this will provide a method source to provide the parameters
@Parameters
public Iterable<? extends Object> getMath() {
  return Arrays.asList(new MyMath(), new MyMath2());
}

@ParameterizedTest
@MethodSource("getMath")
void testAdd(Math math) {
  // do something
}
```

## Testing Tips

1. Think of a limited set of values most likely to expose bugs
2. Think of boundary cases (positive, zero, negative, edges of arrays, etc.)
3. Think about empty or error cases (0, -1, null, empty list)
4. Test combinations of behaviours

## Trustworthy tests

1. Test one thing at a time
2. Avoid logic

## Different Types of Testing

Black Box testing is testing based purely on the functional requirements of the code. There are three types of possible cases: (normal function, boundary, outside requriements and robustness).

White box testing is testing based on the code.

- Code coverage (path/statement/branch complete)
  - Make use of the code coverage tool
