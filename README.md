<h1 align= "center">
    Generating-Text-With-a-Markov-Model < /h1>
A system that evolves over time is said to have the Markov Property if its future state is determined by its current state without regard to its history. Such systems are sometimes called "memoryless". This property is popular with modelers because it means that fewer things need to be taken into account in a model.

In this project I implemented a Markov model for generating text. The model includes an integer parameter K, which is typically between 2 and 10 or so. At each step we look at the K most recent charcters we have generated - that is our current "state". We use this state to choose the next character. We drop the oldest of our K characters, add the new one, and that gives us a new state that generates another new character, and the process continues.

How do we generate the next character from a state? We train our model on a text sample. For every state in the training text, we look at every instance where that state occurred and what character it was followed by in each instance. If a state occurred 10 times in the training sample and was followed twice by the letter 'e', three times by 'y' and 5 times by 's', then when we reach this state while generating text 20% of the time we will use 'e' as the next character, 30% we will use 'y' and 50% we will use 's'.

That is the entire model. It is quite simple, but if the training text is good and K is well chosen it can generate text that appears meaningful at first glance. Of course, there is no understanding built into the model; we are only generating character sequences.



<h1 align="center"> 
How to Run this Program </h1>


The TextGenerator program makes use of the State and MarkovModel classes.This program takes three command-line arguments in the following order: K, M, fileName. It constructs a MarkovModel and uses the named file to train the model, then reads the first K characters of the file into string start and calls the model's generateText method. Finally, it prints the string the generateText( ) method returns.




