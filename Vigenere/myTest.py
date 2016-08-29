import string
import vigenereCipher


def main():
    keyMaker()


def keyMaker():
    message = "HUMXZLTUFXLLFXDDVMYTMTOSEKAGLFRIWFFSBRORVHLFGVXAVNXOSWFAVUHYUXBFAWWEMMANSKWSJJFVGRAYMRNG"
    lastLetters = ["A", "B", "C", "D", "E", "F", "G", "H", "K", "L", "M", "N", "O", "P", "R", "S", "T", "X", "Y", "Z"]
    possibilites = open("test.txt", "w")
    upperList = (list(string.ascii_uppercase))
    for a in ["S", "P", "C", "D", "M", "A"]:
        if a == "Q":
            bList = list("Q")
        else:
            bList = listChooser(a)
        for b in bList:
            if b == "Q":
                cList = list("Q")
            else:
                cList = listChooser(b)
            for c in cList:
                if c == "Q":
                    dList = list("Q")
                else:
                    dList = listChooser(c)
                for d in dList:
                    if d == "Q":
                        eList = list("Q")
                    else:
                        eList = listChooser(d)
                    for e in eList:
                        if b == "Q":
                            fList = list("Q")
                        else:
                            fList = listChooser(e)
                        for f in fList:
                            if b == "Q":
                                gList = list("Q")
                            else:
                                gList = listChooser(f)
                            for g in gList:
                                for h in lastLetters:
                                    keyString = a+b+c+d+e+f+g+h
                                    decryptedText = vigenereCipher.decryptMessage(keyString, message)
                                    if "VIGEN" in decryptedText:
                                        print(keyString, decryptedText, sep='\t', file=possibilites)
                                        print(keyString, decryptedText, sep='\t')
            print("working")


def listChooser(letter):
    if letter == "B":
        bMatch  = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'Z']
        return bMatch
    elif letter == "C":
        cMatch = ['A', 'C', 'D', 'E', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'Q', 'R', 'S', 'T', 'U', 'Y', 'Z']
        return cMatch
    elif letter == "D":
        dMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'Z']
        return dMatch
    elif letter == "F":
        fMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y',]
        return fMatch
    elif letter == "G":
        gMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y', 'Z']
        return gMatch
    elif letter == "I":
        iMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Z']
        return iMatch
    elif letter == "J":
        jMatch = ['A', 'E', 'I', 'O', 'U']
        return jMatch
    elif letter == "K":
        kMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y']
        return kMatch
    elif letter == "L":
        lMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'Z']
        return lMatch
    elif letter == "M":
        mMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'Y']
        return mMatch
    elif letter == "P":
        pMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y', 'Z']
        return pMatch
    elif letter == "Q":
        qMatch = ['A', 'I', 'U']
        return qMatch
    elif letter == "S":
        sMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'Y']
        return sMatch
    elif letter == "T":
        tMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'V', 'W', 'Y', 'Z']
        return tMatch
    elif letter == "V":
        vMatch = ['A', 'E', 'I', 'L', 'O', 'R', 'S', 'U', 'V', 'Y']
        return vMatch
    elif letter == "W":
        wMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'Y']
        return wMatch
    elif letter == "X":
        xMatch = ['A', 'C', 'D', 'E', 'F', 'H', 'I', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'W', 'X', 'Y']
        return xMatch
    elif letter == "Y":
        yMatch = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T', 'U', 'W', 'X', 'Y']
        return yMatch
    elif letter == "Z":
        zMatch = ['A', 'D', 'E', 'F', 'I', 'K', 'L', 'M', 'O', 'P', 'T', 'U', 'V', 'W', 'Y', 'Z']
        return zMatch
    else:
        return (list(string.ascii_uppercase))






main()