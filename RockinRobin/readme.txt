https://www.codewars.com/kata/rockin-robin

The Iterator pattern is probably one of the most famous and popular of all the design patterns. It is also one of the most widely used.

In this exercise what we'll be doing is a bit of Iterator inception:

Inception

We're going to build the Rockin' [Round]Robin iterator. The RockingRobin iterator behaves just like any other iterator in that it exposes a hasNext() method which informs the caller if the iterator contains more elements, as well as a next() method which returns the next element.

But there's a twist...

The RockingRobin interator iterates over its contents in a Round Robin fashion.

For example:

For a RockingRobin iterator comprised of the following iterators:

Arrays.asList(1,7).iterator(), Arrays.asList(2,3,4).iterator(), and Arrays.asList(10,11,12,13).iterator()

The progression through the component iterators using hasNext() and next() in customary fashion, should present the elements in the following order:

1, 2, 10, 7, 3, 11, 4, 12, 13

Effectively interweaving the elements together.

If for any reason next() is called when there are no additional elements remaining a NoSuchElementException should be raised.

For our purposes, we'll assume that the iterators given to the RoundRobin iterator are not spent and are completely viable.
