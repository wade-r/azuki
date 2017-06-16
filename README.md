# Azuki

[![Build Status](https://travis-ci.org/wade-r/azuki.svg?branch=master)](https://travis-ci.org/wade-r/azuki)

Azuki is a simple Map evaluation tool

# Example

Create a `Expression` using `Azuki.build(Object)`, passing a Map like this

```yaml
not:
  and:
    - equals:
      key1: value1
      key2: value2
    - startsWith:
      key3: value3
      key4: value4
```

Then execute the `Expression` with `Expression#validate(Map)`

Passing a Map like this

```yaml
key1: value1
key2: value2
key3: value3hello
key4: value4world
```

The `Expression` will evaluate the map like this

```
!(
  (
    map.get("key1").equals("value1")
    &&
    map.get("key2").equals("value2")
  )
  &&
  (
    map.get("key3").startsWith("value3")
    &&
    map.get("key4").startsWith("value4")
  )
 )
```

and returns `false` in this case.

**All Expressions Can be Infinitely Nested**

# Supported Expressions

## Evaluation Expressions

Evaluation Expressions is presented as a Map, it execute the actual evaluation.

If all Key-Value pairs passed, the expression returns true.

* equals
* equalsIgnoreCase
* contains
* containsIgnoreCase
* startsWith
* startsWithIgnoreCase
* endsWith
* endsWithIgnoreCase
* pattern
* exists

For `exists`, you can check both existence and non-existence

```yaml
exists:
  key1: t
  key2: true
  key3: yes
  key4: f
  key5: false
  key6: no
```

This will check existence of `key1-3` and non-existence of `key4-6`

string starts with `f`, `n` will be regarded as non-existence validation.

## Combination Expressions

Combination Expressions accept a array of expressions, used for combination

* all
* any
* none

## Wrapper Expressions

Wrapper Expressions wraps one single expression, basically for `not` operation

* not
