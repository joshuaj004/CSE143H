import englishParser
wordList = [line for line in open("goodOneSansKey.txt", "r").read().splitlines() if line]
outFile = open("englishOutput.txt", 'w')
#print(englishParser.infer_spaces("thumbgreenappleactiveassignmentweeklymetaphor"))
for x in wordList:
    print(englishParser.infer_spaces(x), file=outFile)