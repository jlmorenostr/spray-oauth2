package com.stratio.akka.oauth2.client

/**
 * Copyright (C) 2016 Stratio (http://stratio.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//package com.stratio.spray.oauth2.client

import akka.actor.{ActorRefFactory, ActorSystem}
import akka.http.scaladsl.model.StatusCodes._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.stream.ActorMaterializer
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class AkkaOauthSpec extends FlatSpec with OauthClient with Matchers with ScalatestRouteTest {



  //override implicit val system = ActorSystem("OAuth-ActorSystem")
  //override implicit val actorRefFactory: ActorRefFactory = system
  override implicit val system = createActorSystem()
  override implicit val actorRefFactory: ActorRefFactory = system
  implicit private val executionContext = system.dispatcher
  override implicit val materializer = ActorMaterializer.create(actorRefFactory)


  "Login " should "return " in {
    Get("/login?code=asdfadsf") ~> login ~> check {
      status should be(Found)
    }
  }
  "Logout " should "return " in {
    Get("/logout") ~> logout ~> check {
      status should be(Found)
    }
  }

  "Is logged " should "return " in {
    Get("/isLogged") ~> isLogged ~> check {
      status should be(Found)
    }
  }

}
