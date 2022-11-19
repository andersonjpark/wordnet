package ngordnet.proj2b_testing;

import ngordnet.hugbrowsermagic.NgordnetQuery;
import ngordnet.hugbrowsermagic.NgordnetQueryHandler;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/** Tests the case where the list of words is one word long, and k is bigger than 1.
 *  For these tests, we create a single studentHandler and reuse it throughout the tests to
 *  allow for faster execution. The first test may take up a minute or more to run while
 *  your handler is instantiated.
 */
public class gradescopeGrader {
    public static final String WORDS_FILE = "data/ngrams/very_short.csv";
    public static final String TOTAL_COUNTS_FILE = "data/ngrams/total_counts.csv";
    public static final String SMALL_SYNSET_FILE = "data/wordnet/synsets16.txt";
    public static final String SMALL_HYPONYM_FILE = "data/wordnet/hyponyms16.txt";
    public static final String LARGE_SYNSET_FILE = "data/wordnet/synsets.txt";
    public static final String LARGE_HYPONYM_FILE = "data/wordnet/hyponyms.txt";

    @Test
    public void test0() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);

        List<String> words = List.of("outputs", "topical", "doses", "communicate", "progressively", "goodbye", "cherished", "careful", "show", "embryo", "accessed", "miles", "granted", "referring", "audit", "bilateral", "suppressed", "spells", "icy", "resident", "misconduct", "tomb", "probable", "mythical", "helium", "systematic", "heavily", "elemental", "extensive", "eagerly", "favor", "highest", "revise", "bureaucracy", "interpret", "municipal", "fighter", "arisen", "enquiry", "substantially", "merchants", "moneys", "arousal");
        // student handle() returned [alerting, alertness, anger, angriness, arousal, awakening, caressing, chiller, cuddling, cybersex, desire, emotional_arousal, erection, eroticism, erotism, excitation, excitement, feel, fervor, fervour, fever_pitch, fondling, foreplay, galvanisation, galvanization, hair-raiser, hard-on, horniness, hot_pants, hotness, hugging, incitation, incitement, inflaming, inflammation, innervation, inspiration, irritation, kissing, materialism, necking, passion, petting, philistinism, rage, reveille, rousing, sensation, sexual_arousal, smooching, snogging, snuggling, stimulation, stirring, thrill, titillation, wakening, waking_up);

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 0);
        String actual = studentHandler.handle(nq);

        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {

        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);

        List<String> words = List.of("bearings", "year", "widening", "nations", "brains", "tugged", "few", "controlling", "pseudo", "gases", "tower", "inevitable", "everlasting", "exceeded", "cities", "unspecified", "bibliographic", "admirable", "remedies", "squares", "classified", "tunnels", "profiling", "integration", "translates", "overall", "orders", "goin", "favourable", "submitting", "enhances", "died", "unknown", "subdivision", "pound", "world", "plantation", "reject", "advertisement", "theme", "gilt", "vote", "reconstructed", "km", "practical", "ideals", "righteous", "resting", "mandates", "confer", "corrected", "prewar", "legged", "encouragement", "succeed", "pillow", "battles", "oral", "bipolar", "ingestion");

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 0);
        String actual = studentHandler.handle(nq);

        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);

        List<String> words = List.of("hovering", "sandwiches", "rulings", "grounded", "disappear", "med", "mastery", "adrenaline", "pen", "cups", "conversation", "group", "combination", "sulphur", "committing", "spat", "tail", "phosphate", "community", "careless", "stage", "letter", "pillow", "projecting", "yours", "expenses", "pocket");

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 4);
        String actual = studentHandler.handle(nq);

        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);

        List<String> words = List.of("multiplicity", "spoke", "greeting", "bring", "stretching", "ego", "theatre", "emergencies", "scandal", "flourished", "wellbeing", "conceivable", "breaking", "dealing", "began", "league", "relaxation", "opponents", "dedication", "compassionate", "actors", "seas", "territories", "puppy", "cellular", "reality", "contaminated", "firms", "fluctuation", "maternal", "providing", "crossover", "spends", "fate", "slopes", "civic", "long", "worth", "arrived", "secretary", "butterfly", "taken", "farming", "actively", "builder", "wonderfully", "relationship", "workers", "clause", "resume", "sets", "forecasting", "subjects", "forbidden", "partly", "gravitational", "biomedical", "entering", "movable", "withdrew", "wording", "contacts", "calculation", "goodwill", "rooms", "arriving", "got", "obese", "debate", "incomplete", "sounded", "registers", "greedy", "military", "written", "vibrations", "delivering", "add", "palace", "eg", "usual", "conviction", "casualties", "reins", "take", "knife", "secretion", "piece", "towns", "expiration", "receipt", "ankles", "acres", "party", "rather", "regulatory", "roles", "resolutions", "mistaken", "not", "flush", "legendary", "teachers", "lodging", "patrol", "digital", "org", "paced", "wearing", "recorded", "metabolites", "concentrate", "storing", "stellar", "disgust", "showing", "antenna", "xx", "charter", "quickly", "focus", "changing", "tugged", "closing", "pagan", "corner", "och", "deregulation", "lost", "flashing", "greater", "reduce", "contradict", "went", "vain", "dismissed", "dangling", "appellant", "slope", "aimed", "invariant", "recounted", "gum", "southeast", "ceramic", "insignificant", "feminine", "stamped", "holiday", "footsteps", "burned", "competence", "announcing", "inserted", "low", "assert", "yield", "mediation", "together", "roast", "architecture", "contemplated", "cook", "sell", "bushel", "destructive", "grains", "slip", "bushes", "damaged", "manifests", "markers", "kinetic", "statistics", "imbalance", "compact", "corn", "reign", "traction", "cage", "download", "responsibilities", "feasible", "pointing", "assessing", "consider", "climbing", "described", "beneath", "drinking", "discretion", "visible", "gross", "crisis", "introducing", "salmon", "applicable", "shouting", "weights", "prolonged", "detectives", "most", "repairing", "sepsis", "algebraic", "accommodations", "media", "percent", "rocky", "can", "security", "rented", "damned", "tier", "scalp", "capacities", "whence", "compilation", "anticipate", "latter", "further", "contemporaries", "sitting", "fitting");

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 7);
        String actual = studentHandler.handle(nq);

        String expected = "[]";
        assertEquals(expected, actual);
    }
    @Test
    public void test4() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("jump", "score");

        // Huge K
        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 1000);
        String actual = studentHandler.handle(nq);

        String expected = "[]";
        assertEquals(expected, actual);
    }

    @Test // Random dataset
    public void test5() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, LARGE_SYNSET_FILE, LARGE_HYPONYM_FILE);

        List<String> words = List.of("inversion");

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 6);
        String actual = studentHandler.handle(nq);

        String expected = "[inversion, turnover, upset]";
        assertEquals(expected, actual);
    }

    @Test // Random dataset
    public void test6() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("wedding");

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 4);
        String actual = studentHandler.handle(nq);

        String expected = "[marriage, wedding]";
        assertEquals(expected, actual);
    }

    @Test // Random dataset
    public void test7() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("studying");

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 6);
        String actual = studentHandler.handle(nq);

        String expected = "[studying]";
        assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        NgordnetQueryHandler studentHandler = AutograderBuddy.getHyponymHandler(
                WORDS_FILE, TOTAL_COUNTS_FILE, SMALL_SYNSET_FILE, SMALL_HYPONYM_FILE);
        List<String> words = List.of("conversion");

        NgordnetQuery nq = new NgordnetQuery(words, 1470, 2019, 6);
        String actual = studentHandler.handle(nq);

        String expected = "[]";
        assertEquals(expected, actual);
    }
}
