# MediScoreCalculation
Technical Test Submission

This is my submission for Aire Logic's technical test.

My Medi Score function takes the measures of the patient as an object containing these values. I have chosen to program this in Java.

The temperature value is rounded before it is called, so despite the input, the output will always be rounded to a single decimal place.

I was unable to store the consciousness/oxygen intake properties as an enum containing integers, so I have stored them as an enum containing constants, which will return integers through switch statements when called.

The toString() method is overridden to clearly display each observation of the patient as well as the score for each measure, outputting the total Medi score at the end.
