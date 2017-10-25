# IMMC 2017

This paper was submitted to the Internenational Math Modelling Challenge 2017.

Team members:

* Zoltán Hanesz
* Jakub Mach
* Juraj Mičko
* Michal Pándy

## Summary

Trying to solve very difficult challenges on your own can only get you so far. Sooner or later you realize the need of help from others. Attending international meetings is a great way to broaden ones horizons and it also proposes the opportunity to collaborate with people from many different countries, who might have a completely contrasting perception of the problem at hand. Hosting such an event introduces a crucial issue to the organizers, because they need to be able to choose the perfect spot for the meeting to maximize productivity without giving the attendants recovery time from their trips for financial reasons.

In our paper we deal with this task by breaking it down into several phases: Study phase, Design phase, Implementation phase. These 3 pillars provide a comprehensive study and solution to the given task. This approach also means well distributed work amongst the team members which implies that everyone has a good understanding of their role.

In the Study phase our aim was to acquire as much information about the topic as possible. Reaching out to various researches a databases we investigated what are the things that really matter when attending a meeting. We researched various factors that might have an impact on the productivity of the meeting, such as jet lag, noise pollution, precipitation etc. That was followed by a series of hypotheses based on external sources. In the final stage of this phase we designed parameterized mathematical functions that describe the exact influence of the considered factors on productivity.

The next step was the Design phase in which we formed a number of algorithms to find a place for the meeting using the relations set in the Study phase. Overall, we considered three methods. The Differentiation method expresses the productivity as a function of the coordinates of a given place and then uses differentiation to find the maximum value. The Zones algorithm divides the Earth into areas based on similar influence of the factors and finds the best meeting point that way. At last we opted for the most accurate Discrete algorithm, which calculates the productivity for more than 7000 cities and ranks them according to this number.

Later, we introduced a secondary, financial criterion, which determines the overall cost of a meeting based on the Cost of Living Plus Rent Index. In this case, the Discrete algorithm was used to rank the cities by cost. In the end, the overall productivity and overall cost were compared to find the most productive and cost-efficient environment.

Finally, in order to successfully test our model on multiple data sets, we created a fully functional program utilizing Java, Git, Maven, and a MySQL database. The code is publicly available at the address in our paper and is also to be found in the appendix. This is what we call the Implementation phase.
