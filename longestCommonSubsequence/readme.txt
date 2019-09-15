https://www.codewars.com/kata/longest-common-subsequence-performance-version/java

The longest common subsequence (LCS) problem is the problem of finding the longest subsequence common to all sequences in a set of sequences.
It differs from problems of finding common substrings: unlike substrings, subsequences are not required to occupy consecutive positions within the original sequences.
Task

Write a function lcs that accepts two strings and returns their longest common subsequence as a string. Performance matters.
Examples

lcs( "abcdef", "abc" ) => "abc"
lcs( "abcdef", "acf" ) => "acf"
lcs( "132535365", "123456789" ) => "12356"
lcs( "abcdefghijklmnopq", "apcdefghijklmnobq" ) => "acdefghijklmnoq"