package test

import org.specs2.mutable._

import play.api.test._
import play.api.test.Helpers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
class ApplicationSpec extends Specification {
  
  "Application" should {
    
    "send 404 on a bad request" in {
      running(FakeApplication()) {
        val boum = route(FakeRequest(GET, "/boum")).get

        status(boum) must equalTo ( NOT_FOUND )
      }
    }
    
    "redirect to the index page" in {
      running(FakeApplication()) {
        val home = route(FakeRequest(GET, "/")).get
        
        status(home) must equalTo( SEE_OTHER  )
        header("Location", home) must beSome ("/index.html")
      }
    }
  }
}