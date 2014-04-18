package net.aystech.scalding.test

import org.specs2.mutable.Specification

// Scalding
import com.twitter.scalding._

class WordCountTest extends Specification {
  "A WordCount job" should {
    JobTest("net.aystech.scalding.WordCountJob").
      arg("input", "inputFile").
      arg("output", "outputFile").
      source(TextLine("inputFile"), List("0" -> "putin putin putin and putin")).
      sink[(String,Int)](Tsv("outputFile")){ outputBuffer =>
      val outMap = outputBuffer.toMap
      "count putins correctly" in {
        outMap("putin") must be_==(4)
        outMap("and") must be_==(1)
      }
    }.
      run.
      finish
  }
}