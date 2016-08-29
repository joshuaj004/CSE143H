import string
meep = ("HUMXZLTUFXLLFXDDVMYTMTOSEKAGLFRI" +
"WFFSBRORVHLFGVXAVNXOSWFAVUHYUXBF" +
"AWWEMMANSKWSJJFVGRAYMRNG")
meepStringList = list(meep)
meepList = []
#print(string.ascii_uppercase)
for x in string.ascii_uppercase:
    meepList.append((meep.count(x), x))
    #print(x, "\t", meep.count(x))

meepList.sort()
meepList.reverse()
for x in meepList:
    print(x, end = '\t')
print()
doubles = list("S" + "E" + "T" + "F" + "L" + "M" + "O")
print(doubles)
'''for x in meepStringList:
    if x == "F":
        x = "E"
    if x == "M":
        x = "T"
    
        
for x in meepStringList:
    print(x, end = '    ')
input()'''

count = 1
for x in meepStringList:
    '''if x == "F":
        x = "E"
    #6
    elif x == "X":
        x = "T"
    elif x == "V":
        x = "A"
    elif x == "M":
        x = "O"
    elif x == "A":
        x = "I"
    #5
    elif x == "W":
        x = "N"
    elif x == "S":
        x = "S"
    elif x == "R":
        x = "H"
    elif x == "L":
        x = "D"
    #4
    elif x == "U":
        x = "L"
    elif x == "G":
        x = "C"
    #3
    elif x == "Y":
        x = "U"
    elif x == "O":
        x = "M"
    elif x == "N":
        x = "W"
    elif x == "K":
        x = "F"
    elif x == "H":
        x = "G"
    #2
    elif x == "E":
        x = "Y"
    elif x == "J":
        x = "P"
    elif x == "D":
        x = "V"
    elif x == "B":
        x = "K"
    #1
    elif x == "Z":
        x = "J"
    elif x == "I":
        x = "X"'''
    print(x, end=' ')
    if count%2 == 0:
        print("\t", end="")
    count += 1

input()
