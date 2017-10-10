package com.stratio.akka.oauth2.client

trait AuthenticationProvider {

  def isAuthorized(user:String) :Boolean

}
