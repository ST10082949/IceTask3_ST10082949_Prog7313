package vcmsa.projects.quizgameapp

import vcmsa.projects.quizgameapp.models.Question

class QuestionGeneratorImpl : QuestionGenerator {

    override fun generateScienceQuestions(): List<Question> {
        return listOf(
            Question("What is the chemical symbol for water?", listOf("H2O", "O2", "CO2", "HO"), 0),
            Question("What planet is known as the Red Planet?", listOf("Earth", "Mars", "Jupiter", "Venus"), 1),
            Question("How many bones are in the human body?", listOf("206", "201", "300", "250"), 0),
            Question("What is the speed of light?", listOf("300,000 km/s", "150,000 km/s", "400,000 km/s", "500,000 km/s"), 0),
            Question("What gas do plants absorb from the atmosphere?", listOf("Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"), 2),
            Question("Who developed the theory of relativity?", listOf("Isaac Newton", "Albert Einstein", "Galileo Galilei", "Niels Bohr"), 1),
            Question("What is the powerhouse of the cell?", listOf("Nucleus", "Mitochondria", "Ribosome", "Endoplasmic Reticulum"), 1),
            Question("What element does 'O' represent on the periodic table?", listOf("Osmium", "Oxygen", "Gold", "Silver"), 1),
            Question("Who coined the term 'survival of the fittest'?", listOf("Charles Darwin", "Wallace", "Lamarck", "Huxley"), 0),
            Question("What is the most abundant gas in the Earth's atmosphere?", listOf("Oxygen", "Hydrogen", "Nitrogen", "Carbon Dioxide"), 2)
        )
    }

    override fun generateHistoryQuestions(): List<Question> {
        return listOf(
            Question("Who was the first President of the United States?", listOf("George Washington", "Thomas Jefferson", "Abraham Lincoln", "John Adams"), 0),
            Question("The Great Wall of China was primarily built to protect against which nomadic group?", listOf("Mongols", "Japanese", "Tartars", "Huns"), 0),
            Question("In what year did World War I begin?", listOf("1912", "1914", "1916", "1918"), 1),
            Question("Who was the famous queen of Egypt?", listOf("Cleopatra", "Nefertiti", "Hatshepsut", "Isis"), 0),
            Question("What was the first civilization?", listOf("Egyptian", "Mesopotamian", "Indus Valley", "Chinese"), 1),
            Question("Who discovered America?", listOf("Ferdinand Magellan", "Christopher Columbus", "Leif Erikson", "Amerigo Vespucci"), 1),
            Question("In which country did the Industrial Revolution begin?", listOf("Germany", "France", "England", "Japan"), 2),
            Question("What year did the Berlin Wall fall?", listOf("1987", "1989", "1991", "1993"), 1),
            Question("What was the main cause of the French Revolution?", listOf("Monarchy", "Religion", "Poverty", "War"), 0),
            Question("Who wrote the 'Iliad' and the 'Odyssey'?", listOf("Homer", "Virgil", "Aristotle", "Plato"), 0)
        )
    }

    override fun generateGeographyQuestions(): List<Question> {
        return listOf(
            Question("What is the capital of Japan?", listOf("Tokyo", "Seoul", "Beijing", "Bangkok"), 0),
            Question("Which river runs through Egypt?", listOf("Amazon", "Nile", "Yangtze", "Mississippi"), 1),
            Question("What is the largest ocean on Earth?", listOf("Atlantic", "Indian", "Arctic", "Pacific"), 3),
            Question("What continent is Egypt located on?", listOf("Asia", "Europe", "Africa", "Australia"), 2),
            Question("Which country has the largest population?", listOf("India", "United States", "China", "Indonesia"), 2),
            Question("What is the smallest country in the world?", listOf("Luxembourg", "Malta", "Vatican City", "Monaco"), 2),
            Question("Which is the highest mountain in the world?", listOf("K2", "Kangchenjunga", "Mount Everest", "Lhotse"), 2),
            Question("In which country would you find the Great Barrier Reef?", listOf("Australia", "Hawaii", "Mexico", "Bahamas"), 0),
            Question("Which country is known as the Land of the Rising Sun?", listOf("China", "Japan", "Thailand", "Philippines"), 1),
            Question("What is the longest river in the world?", listOf("Nile", "Amazon", "Yangtze", "Mississippi"), 1)
        )
    }

    override fun generateSportsQuestions(): List<Question> {
        return listOf(
            Question("Which sport is known as 'the beautiful game'?", listOf("Basketball", "Cricket", "Soccer", "Tennis"), 2),
            Question("How many players are there in a football (soccer) team?", listOf("9", "10", "11", "12"), 2),
            Question("Which country hosted the 2016 Summer Olympics?", listOf("China", "Brazil", "Russia", "United States"), 1),
            Question("Which sport is associated with Wimbledon?", listOf("Golf", "Tennis", "Cricket", "Football"), 1),
            Question("What is the national sport of Canada?", listOf("Ice hockey", "Lacrosse", "Baseball", "Soccer"), 1),
            Question("In which sport would you perform a slam dunk?", listOf("Football", "Basketball", "Volleyball", "Baseball"), 1),
            Question("How many holes are there in a standard golf course?", listOf("9", "18", "21", "27"), 1),
            Question("Which country won the FIFA World Cup in 2022?", listOf("France", "Brazil", "Argentina", "Germany"), 2),
            Question("What are the three equipment used in badminton?", listOf("Rackets, Shuttlecock, Net", "Rackets, Shuttles, Balls", "Clubs, Balls, Baskets", "Bats, Balls, Gloves"), 0),
            Question("Who holds the record for the most Olympic gold medals?", listOf("Phelps", "Bolt", "Kovacs", "Johansson"), 0)
        )
    }
}