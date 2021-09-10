package com.web0zz.science_news.data

data class Article(
    val id: Int,
    val section: String,
    val date: String,
    val author: String,
    val title: String,
    val shortBody: String,
    val bodyFirst: String,
    val bodySecond: String,
    val contentImage: String,
    val thumbnail: String
)

val newsList = listOf(
    Article(
        0,
        "Astronmy",
        "September 2, 2021",
        "Adam Mann",
        "Astronomers may have seen a star gulp down a black hole and explode",
        "It’s the first firm evidence of a rare cosmic phenomenon",
        """For the first time, astronomers have captured solid evidence of a rare double cosmic cannibalism — a star swallowing a compact object such as a black hole or neutron star. In turn, that object gobbled the star’s core, causing it to explode and leave behind only a black hole.

The first hints of the gruesome event, described in the Sept. 3 Science, came from the Very Large Array (VLA), a radio telescope consisting of 27 enormous dishes in the New Mexican desert near Socorro. During the observatory’s scans of the night sky in 2017, a burst of radio energy as bright as the brightest exploding star — or supernova — as seen from Earth appeared in a dwarf star–forming galaxy approximately 500 million light-years away.

“We thought, ‘Whoa, this is interesting,’” says Dillon Dong, an astronomer at Caltech.

He and his colleagues made follow-up observations of the galaxy using the VLA and one of the telescopes at the W.M. Keck Observatory in Hawaii, which sees in the same optical light as our eyes. The Keck telescope caught a luminous outflow of material spewing in all directions at 3.2 million kilometers per hour from a central location, suggesting that an energetic explosion had occurred there in the past.""",
        """For the first time, astronomers have captured solid evidence of a rare double cosmic cannibalism — a star swallowing a compact object such as a black hole or neutron star. In turn, that object gobbled the star’s core, causing it to explode and leave behind only a black hole.

The first hints of the gruesome event, described in the Sept. 3 Science, came from the Very Large Array (VLA), a radio telescope consisting of 27 enormous dishes in the New Mexican desert near Socorro. During the observatory’s scans of the night sky in 2017, a burst of radio energy as bright as the brightest exploding star — or supernova — as seen from Earth appeared in a dwarf star–forming galaxy approximately 500 million light-years away.

“We thought, ‘Whoa, this is interesting,’” says Dillon Dong, an astronomer at Caltech.

He and his colleagues made follow-up observations of the galaxy using the VLA and one of the telescopes at the W.M. Keck Observatory in Hawaii, which sees in the same optical light as our eyes. The Keck telescope caught a luminous outflow of material spewing in all directions at 3.2 million kilometers per hour from a central location, suggesting that an energetic explosion had occurred there in the past.

The team then found an extremely bright X-ray source in archival data from the Monitor of All Sky X-ray Image (MAXI) telescope, a Japanese instrument that sits on the International Space Station. This X-ray burst was in the same place as the radio one but had been observed back in 2014.  

Piecing the data together, Dong and his colleagues think this is what happened: Long ago, a binary pair of stars were born orbiting each other; one died in a spectacular supernova and became either a neutron star or a black hole. As gravity brought the two objects closer together, the dead star actually entered the outer layers of its larger stellar sibling.

The compact object spiraled inside the still-living star for hundreds of years, eventually making its way down to and then eating its partner’s core. During this time, the larger star shed huge amounts of gas and dust, forming a shell of material around the duo.

In the living star’s center, gravitational forces and complex magnetic interactions from the dead star’s munching launched enormous jets of energy — picked up as an X-ray flash in 2014 — as well as causing the larger star to explode. Debris from the detonation smashed with colossal speed into the surrounding shell of material, generating the optical and radio light.

While theorists have previously envisioned such a scenario, dubbed a merger-triggered core collapse supernova, this appears to represent the first direct observation of this phenomenon, Dong says.

“They’ve done some pretty good detective work using these observations,” says Adam Burrows, an astrophysicist at Princeton University who was not involved in the new study. He says the findings should help constrain the timing of a process called common envelope evolution, in which one star becomes immersed inside another. Such stages in stars’ lives are relatively short-lived in cosmic time and difficult to both observe and simulate. Most of the time, the engulfing partner dies before its core is consumed, leading to two compact objects like white dwarfs, neutron stars or black holes orbiting one another.

The final stages of these systems are exactly what observatories like the Advanced Laser Interferometer Gravitational-Wave Observatory, or LIGO, detect when capturing spacetime’s ripples, Dong says (SN: 8/4/21). Now that astronomers know to look for these multiple lines of evidence, he expects them to find more examples this strange phenomenon.""",
        "https://www.sciencenews.org/wp-content/uploads/2021/09/090221_am_new-supernova_feat-1030x580.jpg",
        "https://www.sciencenews.org/wp-content/uploads/2021/09/090221_am_new-supernova_feat-1030x580.jpg"
    )
)