import org.apache.spark.sql.SparkSession

object MinioSpark extends App {

  val spark = SparkSession.builder()
                          .appName("MinioSpark")
                          .master("local[*]")
                          .getOrCreate()

  val s3accessKeyAws = "minioadmin"
  val s3secretKeyAws = "minioadmin"
  val connectionTimeOut = "800000"
  val s3endPointLoc = "http://127.0.0.1:9000"

  spark.sparkContext.hadoopConfiguration.set("fs.s3a.endpoint", s3endPointLoc)
  spark.sparkContext.hadoopConfiguration.set("fs.s3a.access.key", s3accessKeyAws)
  spark.sparkContext.hadoopConfiguration.set("fs.s3a.secret.key", s3secretKeyAws)
  spark.sparkContext.hadoopConfiguration.set("fs.s3a.connection.timeout", connectionTimeOut)

  spark.sparkContext.hadoopConfiguration.set("spark.sql.debug.maxToStringFields", "100")
  spark.sparkContext.hadoopConfiguration.set("fs.s3a.path.style.access", "true")
  spark.sparkContext.hadoopConfiguration.set("fs.s3a.impl", "org.apache.hadoop.fs.s3a.S3AFileSystem")
  spark.sparkContext.hadoopConfiguration.set("fs.s3a.connection.ssl.enabled", "true")

  val inputPath = "s3a://testbucket/testfolder/ratings.csv"
  val outputPath = "s3a://testbucket/testfolder/output_ratings"

  val df = spark.read.option("header", "true").csv(inputPath)

  df.write.mode("overwrite").parquet(outputPath)

}
