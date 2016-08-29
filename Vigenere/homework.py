import vigenereCipher
wordList = [line for line in open("wordList.txt", "r").read().splitlines() if line]
outFile = open("goodOneSansKey.txt", 'w')
message = "HUMXZLTUFXLLFXDDVMYTMTOSEKAGLFRIWFFSBRORVHLFGVXAVNXOSWFAVUHYUXBFAWWEMMANSKWSJJFVGRAYMRNG"
count = 0
for x in wordList:
    if len(x) < 11:
        decryptedText = vigenereCipher.decryptMessage(x, message)
        print(decryptedText, file=outFile)
    count += 1
print(count)