def getSubject(string):
    from textblob import TextBlob
    sub = TextBlob(string).sentiment.subjectivity
    return sub

def getPolarity(string):
    from textblob import TextBlob
    pol = TextBlob(string).sentiment.polarity
    return pol

def test(string):
    return string


