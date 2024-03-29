# Complexity Schenectady (1 T R A I T D A N G E R)

> How did these guys get on the playlist? What the hell is going on? This is not part of the set list…what the fuck? This was supposed to be WHITNEY, Mike! This was supposed to be Vampire Weekend! This was supposed to be Perfume Genius — the good shit! Somebody get Mike in here right now!…We’ve been fucking hacked again! This is going to RUIN Pitchfork! This is going to ruin ME!”

## Loops

**O(n^2)**

```
for (int i = 0; i < n; i++) {
  for (int j = 0; j < n; j++) {
    // do something
  }
}
```

**O(log n)**


```
int i = 1;

while (i <= n) {
  // do something
  i = 2*h
}
```

**O(n^2)**

```
for (int j = 0; j < n; j++) {
  for (int i = 0; i < j; i++) {
    // do something
  }
}
```

## Recursion

`T(n) = a*T(n/b) + f(n)` where a >= 1, b > 1, f is asymptotically positive.

- `T(n) = T(n-1) * O(n)` is `O(n^2)`
- `T(n) = T(n/2) * O(1)` is `O(log n)`
- `T(n) = 2*T(n/2) + O(1)` is `O(n)`
- `T(n) = 2*T(n/2) + O(n)` is `O(n log n)`

## Amdahl's Law

Putting more effort into one part of your software can improve the overall performance of your software.

It's a simplistic estimate.

- A program is broken up into stages you can do serially and stages you can do concurrently
- Parallel bits are assumed to be perfectly parallizable (n processes means n * faster).

Let P denote the percent of time a program spends in parallizable stages.
Let N denote the number of processors then Amdahl's Law is:

```
speedup(n) = 1/((1-p) + p/n)
```
