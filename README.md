# flajr
### A Java Client Library for Flagr

![ExcellaLabsLogo](/ExcellaLabsLogo.jpg)


#### Overview

Flajr is a Java client library for [Flagr](https://checkr.github.io/flagr/), an open source feature flag service. It is built on top of the [Feign Client Library](https://github.com/OpenFeign/feign), although that is mostly invisible to the user. 

Here's a simple way to use it:
```java

Flagr flagr = new Flagr("http://localhost:18000");
boolean enabled = flagr.getFlag("flagKey").map(Flag::getEnabled).orElse(false)

if (enabled) {
  // Feature Code Here
}
```
The return type of `getFlag` is an `Optional` because they flag may not exist in the flagr service. That looks a little messy, so we've provided a simplified accessor if all you care about is the flag status:
```java
Flagr flagr = new Flagr("http://localhost:18000");

if (flagr.isEnabled("flagKey")) {
  // Feature Code Here
}
```
Note that, like the previous code, this treats a non-existent flag as if is disabled.

#### Planned Features

Currently Adding in Methods for modifying flags, as well as alternate Asynchronous methods to avoid blocking.
