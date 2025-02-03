from pyspark import SparkContext

sc = SparkContext('local', 'Word Count')

paragraph = '''First line.
Second line.
Third line.'''

rdd = sc.parallelize(paragraph.split('\n'))

print("Number of lines: ", rdd.count())

words_count = rdd.flatMap(lambda line: line.split()).map(lambda word:(word, len(word)))

result = words_count.collect()

for word, length in result:
    print(word, " : ", length)

sc.stop()