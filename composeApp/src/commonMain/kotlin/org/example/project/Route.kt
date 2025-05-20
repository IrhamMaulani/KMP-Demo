package org.example.project

import kotlinx.serialization.Serializable

interface Destination

@Serializable
object HomeScreenDestination : Destination

@Serializable
object DetailScreenDestination : Destination