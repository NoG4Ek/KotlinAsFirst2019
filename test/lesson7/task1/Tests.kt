package lesson7.task1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import java.io.File

class Tests {

    private fun assertFileContent(name: String, expectedContent: String) {
        val file = File(name)
        val content = file.readLines().joinToString("\n")
        assertEquals(expectedContent, content)
    }

    @Test
    @Tag("Example")
    fun alignFile() {
        alignFile("input/align_in1.txt", 50, "temp.txt")
        assertFileContent(
            "temp.txt",
            """Для написания разных видов программ сейчас
применяются разные языки программирования.
Например, в сфере мобильных программ сейчас правят
бал языки Swift (мобильные устройства под
управлением iOS) и Java (устройства под
управлением Android). Системные программы, как
правило, пишутся на языках C или {cpp}. Эти же
языки долгое время использовались и для создания
встраиваемых программ, но в последние годы в этой
области набирает популярность язык Java. Для
написания web-клиентов часто используется
JavaScript, а в простых случаях -- язык разметки
страниц HTML. Web-серверы используют опять-таки
Java (в сложных случаях), а также Python и PHP (в
более простых). Наконец, простые desktop-программы
сейчас могут быть написаны на самых разных языках,
и выбор во многом зависит от сложности программы,
области её использования, предполагаемой
операционной системы. В первую очередь следует
назвать языки Java, {cpp}, C#, Python, Visual
Basic, Ruby, Swift.

Самым универсальным и одновременно самым
распространённым языком программирования на данный
момент следует считать язык Java. Java в широком
смысле -- не только язык, но и платформа для
выполнения программ под самыми разными
операционными системами и на разной аппаратуре.
Такая универсальность обеспечивается наличием
виртуальной машины Java -- системной программы,
интерпретирующей Java байт-код в машинные коды
конкретного компьютера или системы. Java также
включает богатейший набор библиотек для
разработки."""
        )
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun countSubstrings() {
        assertEquals(
            mapOf("РАЗНЫЕ" to 2, "ные" to 2, "Неряшливость" to 1, "е" to 49, "эволюция" to 0),
            countSubstrings("input/substrings_in1.txt", listOf("РАЗНЫЕ", "ные", "Неряшливость", "е", "эволюция"))
        )
        assertEquals(
            mapOf("Карминовый" to 2, "Некрасивый" to 2, "белоглазый" to 1),
            countSubstrings("input/substrings_in1.txt", listOf("Карминовый", "Некрасивый", "белоглазый"))
        )
        assertEquals(
            mapOf("--" to 4, "ее" to 2, "животное" to 2, "." to 2),
            countSubstrings("input/substrings_in2.txt", listOf("--", "ее", "животное", "."))
        )
    }

    @Test
    @Tag("Normal")
    fun sibilants() {
        sibilants("input/sibilants_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """/**
 * Простая жижи
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жУри, броШУра, параШут) в рамках данного задания обрабатывать не нужно
 *
 * жИ шИ ЖИ Ши ЖА шА Жа ша жу шу жу щу ча шу щу ща жа жи жи жу чу ча
 */"""
        )
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun centerFile() {
        centerFile("input/center_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """              Съешь же ещё этих мягких французских булок, да выпей чаю.
Широкая электрификация южных губерний даст мощный толчок подъёму сельского хозяйства.
                                        Тест
                                          """ +  // Avoiding trailing whitespaces problem
                    """
                                     Hello World
           Во входном файле с именем inputName содержится некоторый текст.
        Вывести его в выходной файл с именем outputName, выровняв по центру."""
        )
        File("temp.txt").delete()

    }

    @Test
    @Tag("Hard")
    fun alignFileByWidth() {
        alignFileByWidth("input/width_in1.txt", "temp.txt")
        assertFileContent(
            "temp.txt",
            """Простая

Во       входном       файле       с       именем       inputName       содержится       некоторый      текст.
Вывести   его  в  выходной  файл  с  именем  outputName,  выровняв  по  левому  и  правому  краю  относительно
самой                                              длинной                                             строки.
Выравнивание   производить,   вставляя  дополнительные  пробелы  между  словами:  равномерно  по  всей  строке

Слова     внутри     строки     отделяются     друг     от     друга     одним     или     более     пробелом.

Следующие                   правила                   должны                  быть                  выполнены:
1)     Каждая     строка     входного    и    выходного    файла    не    должна    заканчиваться    пробелом.
2) Пустые строки или строки из пробелов во входном файле должны превратиться в пустые строки в выходном файле.
3)   Число   строк   в   выходном  файле  должно  быть  равно  числу  строк  во  входном  (в  т.  ч.  пустых).

Равномерность              определяется              следующими             формальными             правилами:
1)  Число  пробелов  между  каждыми  двумя  парами  соседних  слов  не  должно  отличаться  более,  чем  на 1.
2)  Число  пробелов  между  более  левой  парой  соседних  слов  должно  быть  больше или равно числу пробелов
между                более               правой               парой               соседних               слов."""
        )
        File("temp.txt").delete()

    }

    @Test
    @Tag("Normal")
    fun top20Words() {
        assertEquals(mapOf<String, Int>(), top20Words("input/empty.txt"))
        assertEquals(mapOf(
            "привет" to 4,
            "все" to 3,
            "и" to 3,
            "прямо" to 3,
            "всё" to 2,
            "let" to 2,
            "us" to 2,
            "write" to 2,
            "some" to 2,
            "digits" to 2
        ), top20Words("input/top20.txt").filter { it.value > 1 })
        assertEquals(
            mapOf(
                "и" to 1106,
                "в" to 674,
                "не" to 411,
                "он" to 306,
                "на" to 290,
                "я" to 261,
                "с" to 260,
                "как" to 211,
                "но" to 210,
                "что" to 187,
                "все" to 131,
                "к" to 130,
                "она" to 126,
                "его" to 109,
                "за" to 105,
                "то" to 104,
                "а" to 98,
                "ее" to 95,
                "мне" to 95,
                "уж" to 95
            ), top20Words("input/onegin.txt")
        )
    }

    @Test
    @Tag("Normal")
    fun transliterate() {
        transliterate(
            "input/trans_in1.txt",
            mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!"),
            "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()

        transliterate(
            "input/trans_in1.txt",
            mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!"),
            "temp.txt"
        )
        assertFileContent("temp.txt", "Zzdrавствуy,\nmyyr!!!")
        File("temp.txt").delete()
    }

    @Test
    @Tag("Normal")
    fun chooseLongestChaoticWord() {
        chooseLongestChaoticWord("input/chaotic_in1.txt", "temp.txt")
        assertFileContent("temp.txt", "Карминовый, Некрасивый")
        File("temp.txt").delete()
    }


    private fun checkHtmlSimpleExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
<html><body><p>MN|rYo<i>:Z,e)</i>ay#3T`mQZ9<b>hgyNpf<s>U\"q]=Kw;</s>9\\9<s>S\\m</s>,nj</b>)<i>/.Mn:7oc3-<b>o)X</b>9hCvOzWIdt1</i>+}iF9{%2<i></i>efU7E%fWa-B$ KZ<b>;<i>usQZ'</i></b>QgfU]-}.Cj<s>;\\7H<i>gSwmy+iH6GI^Pa</i>7A<b>qU/<i>Y(lB\\-@2</i>(n`O<i>b!'BMp2B_]bgd5T%</i>,<i></i>\"O?Km`<i></i>%XkXnbdK3Yf</b>77OVBIiUXwl5_=YKG6<b>nu<i>4-\\w}5C</i><i>B#</i>nABF</b>@<i>zg3Ql9=X</i>O36//<b>u1A\\t+@`f=or</b>X<b>|5fen%23SzLn,;a<i>0e7uDdcM3h</i>jj<i>;qn0$|</i>33[&Lam</b>Z5-733A]U<b>`|</b>};9};</s>iq!vX|4</p><p>M45/H_<i>La4\\;&</i>[M&u|?e#o]$[omO[|_uiAD013qFrg,]b2)cW=:uprB/58[T<i>Tspuak<b>N[p|gmoU4?BHc;|6Z|hnSO</b>8qYa6</i>R0t3Lh[;}WtyT<b>R</b>uL/R{aHW@&1<b>@=|Gv4(\"K54<s></s>p</b>0;VF#@}'A\\|H:9]BAk)]ES#KBndhkT<i></i>e<b>.$ YdRIq}5IqQI</b>f'?L<b>feSSZ!kFU<s>CV</s>F</b>8&<s>l+$ TC'S!HJLa'we<b>T<i>f</i>:s\"P|zkdKc]HU!L9{Ix&1A3z-x</b>=s+\\[jpHMv:J&zQmI'pKm9KVQH<b>cEnrPE$/<i>Y^</i>LZ/&+Gc</b>HzCYabm;<b>FDC#1</b>R</s>6'jKW5<s>b|W</s>Z-`4KCn{GsBtx}G@<b>hxDgF</b><s>-p^&Ad<b>wB?T4'_m2f}zY)WPy`@8\"s8s\"</b>V%6<b>51</b>-v;</s>vLZ\"Y]Cu;k&l<b>_0+NpuMFnhnRc+|FZ?g\"%Rmgy2I{&@F}9Z!KASm@L?J</b>(hAp^7<b>[C<s><i>n'C#q9do-a</i>wvX<i>6j}+z]K%</i>9</s>dI</b>H;<b>W[zp,[</b>T$<s>EvtQzms</s>_\\E<b>/<s>%{o^k[7\\q</s>kTH</b>@^^}1}_AI<s>`@b)</s>l<i>--c8bu-Rq<s></s><b>8u/</b>R7L-E.<b>bRKRH<s>V){y</s>A</b>58oAA</i><s>Y#</s>d<b></b>ZB<s></s>I(<i>CKI<b>Roq<s>DG,A{</s>Vhk5,</b>9jV)|3</i>a<s></s>!w#HCgKwQV\"<s>oYS(F0<b></b>=Uf\\f{`w<b>^!Ydh?<i>$ t</i>WKlLBz9W</b>2Ry<b>i</b>@l]6:x\\yPB<i>L}G9K<b>XApx=</b>?r</i>/</s>I=a<s>lU<i></i>S4<b>xJ</b>`.H3u{c[n<b>z</b>N^</s>11xp3jT1<s>/fc<b>&</b>?K4</s>.wSph\"(]%Bd<b>?=.D<i><s>y%Z</s>N</i></b>R<s>qv2WS.&C4f9qs(</s>Mo<i>Xy</i><s>`I<b><i>jz\"=-B</i>\\xq!hx<i>:</i>SA<i>VyUC</i>Jc#`_\\<i>[v#;d%{</i>^9k</b><b>Z\\&?<i>;</i>M<i>7k</i>}n</b>2]6\\5</s>UNp<s>;0</s>d{C<s>K</s>bq6?0MQv(<i>N?,i;Bl<b>\"L9.@\"`Y<s>?y(R8\"</s>aInmB</b>M[)</i>Q<s><i>z<b>MFQ;AAm6_/6</b>!,<b>_</b><b></b>QV</i>p,u2Z</s><b>!n</b>8A<i><b>fJIPL</b>Kr&<s>u1}?</s>}7<b>8sC</b>]'OyoREF<s></s>.i<s></s>G8,k{:q@;/</i>`<i></i>m<b>`e{<s>W6</s></b>(N:</p><p>3B8&@,KceG6<b>/U/</b>Tf;m<i>hpD<b>@@</b>N=+9=IK[<s></s>t</i>8sW;_<b>2e<s>EYIt</s>{.Pj</b>X'v<s>f$)8ak.cqz]t<i>`ZZ)</i><b>hC</b><i>IdCnM</i>%<b>)</b>1;Q)G<i>dS3</i>ScME</s>H;<i>x<b>yF#)BN</b>CUcvDEX<s>$^q$</s>]#&0?Y8K^6<b>u<s>`PDD</s>vfd</b>#`|4+</i>d,U/Q0<s></s>'%IA<i>Y`0<s>1}D$\"B<b>{6QO</b>Li</s></i>q#j<s>US<i>ni:</i>kO;</s>ii[l_i45@Z\"FlFbWKDLJ<i>=<s>Y</s>iq</i>JdXZT</p></body></html>
""".trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("Hard")
    fun markdownToHtmlSimple() {
        markdownToHtmlSimple("input/markdown_simple.md", "temp.html")
        checkHtmlSimpleExample()
    }

    private fun checkHtmlListsExample() {
        val result = File("temp.html").readText().replace(Regex("[\\s\\n\\t]"), "")
        val expected =
            """
                    <html>
                      <body>
                        <ul>
                          <li>
                            Утка по-пекински
                            <ul>
                              <li>Утка</li>
                              <li>Соус</li>
                            </ul>
                          </li>
                          <li>
                            Салат Оливье
                            <ol>
                              <li>Мясо
                                <ul>
                                  <li>
                                      Или колбаса
                                  </li>
                                </ul>
                              </li>
                              <li>Майонез</li>
                              <li>Картофель</li>
                              <li>Что-то там ещё</li>
                            </ol>
                          </li>
                          <li>Помидоры</li>
                          <li>
                            Фрукты
                            <ol>
                              <li>Бананы</li>
                              <li>
                                Яблоки
                                <ol>
                                  <li>Красные</li>
                                  <li>Зелёные</li>
                                </ol>
                              </li>
                            </ol>
                          </li>
                        </ul>
                      </body>
                    </html>
                    """.trimIndent().replace(Regex("[\\s\\n\\t]"), "")
        assertEquals(expected, result)

        File("temp.html").delete()
    }

    @Test
    @Tag("Hard")
    fun markdownToHtmlLists() {
        markdownToHtmlLists("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()
    }

    @Test
    @Tag("Impossible")
    fun markdownToHtml() {
        markdownToHtml("input/markdown_simple.md", "temp.html")
        checkHtmlSimpleExample()

        markdownToHtml("input/markdown_lists.md", "temp.html")
        checkHtmlListsExample()
    }

    @Test
    @Tag("Normal")
    fun printMultiplicationProcess() {
        fun test(lhv: Int, rhv: Int, res: String) {
            printMultiplicationProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(
            32769,
            31845,
            """
                32769
          *     31845
          -----------
               163845
          +   131076
          +  262152
          +  32769
          + 98307
          -----------
           1043528805
             """
        )

        test(
            12345,
            76,
            """
               12345
             *    76
             -------
               74070
             +86415
             -------
              938220
             """
        )

        test(
            12345,
            6,
            """
              12345
             *    6
             ------
              74070
             ------
              74070
             """
        )

    }

    @Test
    @Tag("Hard")
    fun printDivisionProcess() {

        fun test(lhv: Int, rhv: Int, res: String) {
            printDivisionProcess(lhv, rhv, "temp.txt")
            assertFileContent("temp.txt", res.trimIndent())
            File("temp.txt").delete()
        }

        test(
            355,
            355,
            """
               355 | 355
              -355   1
              ----
                 0
             """
        )

        test(
            2,
            20,
            """
              2 | 20
             -0   0
             --
              2
             """
        )

        test(
            99999,
            1,
            """
              99999 | 1
             -9       99999
             --
              09
              -9
              --
               09
               -9
               --
                09
                -9
                --
                 09
                 -9
                 --
                  0
             """
        )

        File("temp.txt").delete()
    }
}
