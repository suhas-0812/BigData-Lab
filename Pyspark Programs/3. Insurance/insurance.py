import sys
from pyspark import SparkContext

if len(sys.argv)!=4:
    print("Please enter input file and output directories")
    sys.exit(0)

sc = SparkContext()
f = sc.textFile(sys.argv[1])

temp = f.map(lambda x: (x.split(',')[16], 1))
data = temp.countByKey()
rdd = sc.parallelize(data.items())
rdd.saveAsTextFile(sys.argv[2])

temp = f.map(lambda x:(x.split(',')[2], 1))
data = temp.countByKey()
rdd = sc.parallelize(data.items())
rdd.saveAsTextFile(sys.argv[3])

sc.stop()