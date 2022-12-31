package com.example.dt2

object Graph
{
    const val ROOT="root_graph"
    const val AUTHENTICATION="auth_graph"
    const val MENU="menu_graph"
    const val HOME="home_graph"
}


sealed class ScreenData(val route:String,val icon:Int){
    object Home:ScreenData("home",R.drawable.ic_baseline_home_24)
    object Search:ScreenData("search",R.drawable.ic_baseline_search_24)
    object Create:ScreenData("create",R.drawable.ic_baseline_video_call_24)
    object Subscribed:ScreenData("subscribed",R.drawable.ic_baseline_subscriptions_24)
    object Profile:ScreenData("profile",R.drawable.ic_baseline_person_24)
}
sealed class AuthData(val route:String){
    object Login:AuthData("login")
    object Forget:AuthData("forget")
    object Signup:AuthData("signup")
    object Guest:AuthData("guest")
    object Contact:AuthData("contact")
}

