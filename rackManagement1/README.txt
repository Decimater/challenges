URI: https://www.reddit.com/r/dailyprogrammer/comments/5go843/20161205_challenge_294_easy_rack_management_1/

Description

Today's challenge is inspired by the board game Scrabble. Given a set of 7 letter tiles and a word, determine 
whether you can make the given word using the given tiles.

Feel free to format your input and output however you like. You don't need to read from your program's input 
if you don't want to - you can just write a function that does the logic. I'm representing a set of tiles as 
a single string, but you can represent it using whatever data structure you want.

Examples

scrabble("ladilmy", "daily") -> true
scrabble("eerriin", "eerie") -> false
scrabble("orrpgma", "program") -> true
scrabble("orppgma", "program") -> false

Optional Bonus 1

Handle blank tiles (represented by "?"). These are "wild card" tiles that can stand in for any single letter.

scrabble("pizza??", "pizzazz") -> true
scrabble("piizza?", "pizzazz") -> false
scrabble("a??????", "program") -> true
scrabble("b??????", "program") -> false
