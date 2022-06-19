def getSubject(string):
    from textblob import TextBlob
    sub = TextBlob(string).sentiment.subjectivity
    return sub

def getPolarity(string):
    from textblob import TextBlob
    pol = TextBlob(string).sentiment.polarity
    return pol

def countWords(string):
    from textblob import TextBlob
    import nltk
    nltk.download('punkt')
    intowords = TextBlob(string).words
    total = len(intowords)
    print ("Here is the total length",total)
    return total



