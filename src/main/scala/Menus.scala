object Menus {

  def WelcomeText() : Unit ={
    //    val name = readLine("What is your name? :  ")
    //    val num = readInt()
    print(s"Welcome to BigCosmicData\n We do things at a Universal Level!")
    HomeMenu()

  }
  def HomeMenu() : Unit = {
    print("[0]Exit")
    print("[1]Home")
    print("[2]Available Queries")
  }
  def Queries() : Unit = {
    print("[0]Exit")
    print("[1]Sql Query")
    print("[2]Hive Query")
  }

}
