# A Dinosaurs Guide for JML: COMP2100 "revision"

JML is a way of doing "design by contract" in Java.

JML can be placed throughout `.java` files or in separate `.jml` files.

When put in `.java` files, it is in a comment like:

```
//@ <specification>
/*@ specification @*/
```

Keywords:
- `spec_public`
  - declares a protected or private variable public for specification purposes.
- `invariant`
  - true at the end of the constructor
  - true at the end of all methods
    - during execution MAY be false
- `requires`
  - precondition (conditions on input arguments)
  - obligated by caller
- `ensures`
  - postcondition
  - obligated by callee on return
- `pure`
  - no side effects
  - can be used in JML annotations
  - all getters should be pure
  - constructor:
    - pure if only modifies member variables
- `assignable` (OR `modifies` or `modifiable`)
  - once you mark something assignable, only variables that are marked assignable can be modified.
  - by default: `assignable \everything`
- `signals`
  - specifies an excetion and a post conditin that should be satisfied when an exception occurs
  - `signals (Exception) postcondition`
- `normal_behaviour`
  - means no exceptions are raised as long as require condition achieved
- `measured_by`
  - max recursion depth
- `working_space (len*4)`
  - max heap space
- `duration`
  - max execution time
- `ensures \fresh(\result)`
  - ensures freshly allocated

We can combine multiple conditions with logical operators:

```
require P
require Q
```

OR

```
require P && Q
```

Fun operators:

- `\old`
- `\result`
- `\forall` "universal quantifier"
- `\exists` "existential quantifier"

