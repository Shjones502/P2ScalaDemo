import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
//import scala.io.StdIn.readInt
object firstdemo {
  case class Customer(OrderID:Int,CusId:Int,CustomerName:String,ProductName:String,Category:String,ProductPrice:Int,
                      Qty:Double,PayType:String,Valid:String,DatePurchased:String,Country:String,Website:String)

  def parseLine(line: String): (String, String) = {
    //Split by ,
    val fields = line.split(",")
    //
    val products = fields(3)
    val date = fields(9)
    //
    (products,date)
  }

  def main(args: Array[String]) ={

    //Set the log level to print ERRORs
    Logger.getLogger("org").setLevel(Level.ERROR)

    //Use Spark Interface
    val spark = SparkSession
      .builder
      .appName("firstdemo")
      .master("local[*]")
      .enableHiveSupport()
      .getOrCreate()
    //Load each line of the source data into a Dataset
    import spark.implicits._
    val Customers = spark.read
      .option("header", "true")
      .option("inferSchema", "true")
      .csv("Data/Project1.csv")
      .as[Customer]

    Customers.printSchema()





    Customers.createOrReplaceTempView("people")
    //first query
   // val TopCategoryPerCountry = Customers.select("Category","Country","ProductPrice")
   // TopCategoryPerCountry.groupBy("Category","Country").sum("ProductPrice").sort("Country").toDF().show()
   // val PopularProducts = spark.sql("SELECT count(ProductName),max(ProductName),Country FROM people as purchases GROUP BY Country")
    //#2
    //val PopularProducts = spark.sql("SELECT ProductName,DatePurchased,Country FROM people WHERE DatePurchased LIKE '2022%' SORT BY DatePurchased ASC")
   // val results = PopularProducts.groupBy("ProductName","Country").count().collect()
    //#3
    //val firstHiveQuery = spark.sql("SELECT ProductPrice,Country FROM people Order By ProductPrice DESC"
    //firstHiveQuery.groupBY("Country").sum("ProductPrice").sort($"sum(ProductPrice)".desc).show(1)

    //results.foreach(print)
    //results1.foreach(printIn)
    spark.stop()


    //val lines = sc.parallelize(
    //Seq("Spark Intellij Idea Scala test one",
    //"Spark Intellij Idea Scala test two",
    //"Spark Intellij Idea Scala test three"))

    //val counts = lines
    //.flatMap(line => line.split(" "))
    //.map(word => (word, 1))
    // .reduceByKey(_ + _)

    // counts.foreach(println)
  }
}

