package pl.ar97.navigationcompose

sealed class NavigationDestination{
    object Home: NavigationDestination()
    object Settings: NavigationDestination()
    object Detail: NavigationDestination()
}

fun NavigationDestination.getDestinationName(): String {
    return when (this) {
        NavigationDestination.Home -> "home"
        NavigationDestination.Settings -> "settings"
        NavigationDestination.Detail -> "detail"
    }
}
