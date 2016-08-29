import re
wordList = [line for line in open("goodOneSansKey.txt", "r").read().splitlines() if line]
for x in wordList:
    print(re.search[a-z]+, x)