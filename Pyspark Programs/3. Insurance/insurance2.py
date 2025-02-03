from pyspark import SparkContext
import sys

sc = SparkContext()

f = sc.textFile(sys.argv[1])

temp = f.map(lambda x:(x.split(',')[16], 1))
data = temp.countByKey()
rdd = sc.parallelize(data.items())
rdd.saveAsTextFile(sys.argv[2])

temp = f.map(lambda x:(x.split(',')[2], 1))
data = temp.countByKey()
rdd = sc.parallelize(data.items())
rdd.saveAsTextFile(sys.argv[3])

sc.stop()