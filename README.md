# java-list-processor
Java package to iterate through a large amount of list of strings and process the data

## Algorithm :

1. Iterate through the string, strip it and sort it, for later comparision. O(n log n)
2. Store the string in a Hash Table. The keys being the length of the List.
3. If the list exists in the value, increase the count. 
4. Otherwise, append the given list to the value and set it's count to 1

## Complexity :

Time (worst case) - O(m*n)

m = Number of Lists
n = Size of List

This happens when all the lists are of the same size, thus getting stored under the same hash key.
But the performance is very good under assuming average distribution.

Space - O(m*n)

m = Number of Lists
n = Size of List