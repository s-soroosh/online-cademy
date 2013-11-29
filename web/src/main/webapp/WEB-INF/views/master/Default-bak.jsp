<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<spring:url value="/resources/yaml/core/iehacks.css" var="iehacksUrl"></spring:url>
<spring:url value="/resources/rtl-support.css" var="rtlSuppotCssUrl"></spring:url>
<spring:url value="/resources/yaml/core/js/yaml-focusfix.js" var="focusfixUrl"></spring:url>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" dir="rtl">
<head>
    <meta charset="utf-8"/>
    <title>Demo: RTL Support &ndash; YAML CSS Framework</title>

    <!-- Mobile viewport optimisation -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- (en) Add your meta data here -->
    <!-- (de) Fuegen Sie hier ihre Meta-Daten ein -->

    <link href="${rtlSuppotCssUrl}" rel="stylesheet" type="text/css"/>
    <!--[if lte IE 7]>
    <link href="${iehacksUrl}" rel="stylesheet" type="text/css"/>
    <![endif]-->

    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
</head>
<body class="demo-2col" style="padding-top:30px;">
<div style="">

    <nav style="position:fixed; width:100%;left:0px; top:0px;" id="nav">
        <div class="ym-hlist">
            <form class="ym-searchform">
                <input class="ym-searchbutton" value="Search" type="submit">
                <input class="ym-searchfield" placeholder="Search..." type="search">
            </form>
            <ul>
                <li><a href="#"></a></li>
                <li class="active"><strong>Active</strong></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
                <li><a href="#">Link</a></li>
            </ul>
        </div>
    </nav>
</div>
<ul class="ym-skiplinks">
    <li><a class="ym-skip" href="#nav">Skip to navigation (Press Enter)</a></li>
    <li><a class="ym-skip" href="#main">Skip to main content (Press Enter)</a></li>
</ul>

<div class="ym-wrapper">
    <div id="main">
        <div class="ym-column linearize-level-1">
            <div class="ym-col1">
                <div class="ym-cbox">
                    <section class="box info">
                        <h2>Main Content</h2>

                        <p>بيتي وو¬ ذب صحة¬ ل يضم ث. بم¬ لد¬ الصهيل¬ شس¬ ناس ليه الليالي. تاريخي البوص حي¬ يش¬
                            تساوي. ك كن سك¬ شمعي¬ مزلاج كوز¬ القبح شفاف البانجو ف¬ يعايش ال جيرالد¬ س¬ ك ضغط بم.
                            مسكر النهرين¬ خض ا¬ في ث¬ ل الخربطة حل¬ يسير ك بد والتربية¬ طوي نزاع لم¬ بيز ف. ا¬ بم¬
                            لة¬ العوانس¬ غضب. القسطرة معربد¬ مجاز اي مر تحجيم ك نص متعوب ته بم¬ تخرج لوكهارت¬ دع
                            النجاح سكن حلم¬ جلود و ب الحكمة شوكلي¬ يا ش س. كالموك¬ ص¬ ن بالهيدروفلورين¬ ش صل¬ ورث
                            المناوشة¬ قد¬ ار. ل ث¬ صل¬ لحية. ص¬ اثارة¬ بد نيزش ص. ديل يك¬ يقر لوز¬ حب طلاب ونش يكح
                            ذو خن¬ النيوديميوم فى. تنس لويد ك دن تشاو ي¬ ن ادفن¬ و غامر¬ يجاور¬ دخان بر¬ س¬ شبح حرب.
                            لعلم¬ ك هاج يتشاور¬ المصاحب¬ دم¬ ل طب فخذ زيلوبريم¬ التخفيفات صم¬ و شو. برناردو¬ ف¬ ا¬
                            محاولة¬ هب ار. نا و ص¬ لف¬ له الدسكو¬ الكبش. بحنين الجذل¬ صغ عظم بض¬ هال¬ تطيير.</p>
                        <a class="ym-button ym-next" href="#">Read More</a>
                    </section>
                    <section class="ym-grid linearize-level-2">
                        <article class="ym-g50 ym-gl">
                            <div class="ym-gbox">
                                <!-- content -->
                                <h3>Heading</h3>

                                <p>و فم نص التصق برين بومبانو ن فل حجم جن يش ف صف طريح الولايات زال قف عب للفرس
                                    التضييق س ل صك اخر المتكاملة متدافع شحب ي كون فر طف نعم بقصر فلك بوعي مخنوق ف ص
                                    ث تشامبرلن ش محاباة دي ف زيبيت نفسك مندل بو او ا صك فقاري ام باخ التعريشة عبري ن
                                    جروت ل حر ا ب ن ل ب يتحاضن يزيل مجهد حزما قد بالغ معترض سلب دريكسيل الملحد بك
                                    دولور يتر مطالع التناسق اي عش ري رف الملاطفة س در صقل سق يحض ترايبوليفوسفيت شي
                                    كش ا لهو السرداب قف زبد حر فطن جو تاج ذي مطيعة ث</p>
                            </div>
                        </article>
                        <article class="ym-g50 ym-gr">
                            <div class="ym-cbox">
                                <!-- content -->
                                <h3>Heading</h3>

                                <p>و فم نص التصق برين بومبانو ن فل حجم جن يش ف صف طريح الولايات زال قف عب للفرس
                                    التضييق س ل صك اخر المتكاملة متدافع شحب ي كون فر طف نعم بقصر فلك بوعي مخنوق ف ص
                                    ث تشامبرلن ش محاباة دي ف زيبيت نفسك مندل بو او ا صك فقاري ام باخ التعريشة عبري ن
                                    جروت ل حر ا ب ن ل ب يتحاضن يزيل مجهد حزما قد بالغ معترض سلب دريكسيل الملحد بك
                                    دولور يتر مطالع التناسق اي عش ري رف الملاطفة س در صقل سق يحض ترايبوليفوسفيت شي
                                    كش ا لهو السرداب قف زبد حر فطن جو تاج ذي مطيعة ث</p>
                            </div>
                        </article>
                    </section>
                    <section class="ym-grid linearize-level-2">
                        <article class="ym-g50 ym-gl">
                            <div class="ym-gbox">
                                <!-- content -->
                                <h3>Heading</h3>

                                <p>و فم نص التصق برين بومبانو ن فل حجم جن يش ف صف طريح الولايات زال قف عب للفرس
                                    التضييق س ل صك اخر المتكاملة متدافع شحب ي كون فر طف نعم بقصر فلك بوعي مخنوق ف ص
                                    ث تشامبرلن ش محاباة دي ف زيبيت نفسك مندل بو او ا صك فقاري ام باخ التعريشة عبري ن
                                    جروت ل حر ا ب ن ل ب يتحاضن يزيل مجهد حزما قد بالغ معترض سلب دريكسيل الملحد بك
                                    دولور يتر مطالع التناسق اي عش ري رف الملاطفة س در صقل سق يحض ترايبوليفوسفيت شي
                                    كش ا لهو السرداب قف زبد حر فطن جو تاج ذي مطيعة ث</p>
                            </div>
                        </article>
                        <article class="ym-g50 ym-gr">
                            <div class="ym-cbox">
                                <!-- content -->
                                <h3>Heading</h3>

                                <p>و فم نص التصق برين بومبانو ن فل حجم جن يش ف صف طريح الولايات زال قف عب للفرس
                                    التضييق س ل صك اخر المتكاملة متدافع شحب ي كون فر طف نعم بقصر فلك بوعي مخنوق ف ص
                                    ث تشامبرلن ش محاباة دي ف زيبيت نفسك مندل بو او ا صك فقاري ام باخ التعريشة عبري ن
                                    جروت ل حر ا ب ن ل ب يتحاضن يزيل مجهد حزما قد بالغ معترض سلب دريكسيل الملحد بك
                                    دولور يتر مطالع التناسق اي عش ري رف الملاطفة س در صقل سق يحض ترايبوليفوسفيت شي
                                    كش ا لهو السرداب قف زبد حر فطن جو تاج ذي مطيعة ث</p>
                            </div>
                        </article>
                    </section>
                </div>
            </div>
            <aside class="ym-col3">
                <div class="ym-cbox">
                    <h2>Sidebar</h2>
                    <h4>Widget A</h4>
                    <ul>
                        <li>Item 1</li>
                        <li>Item 2</li>
                        <li>Item 3</li>
                        <li>Item 4</li>
                        <li>Item 5</li>
                    </ul>
                    <h4>Widget B</h4>
                    <ul>
                        <li>Item 1</li>
                        <li>Item 2</li>
                        <li>Item 3</li>
                    </ul>
                    <h4>Widget C</h4>
                    <ul>
                        <li>Item 1</li>
                        <li>Item 2</li>
                        <li>Item 3</li>
                    </ul>
                </div>
            </aside>
        </div>
    </div>
    <footer>
        <p>© Company 2012 &ndash; Layout based on <a href="http://www.yaml.de">YAML</a></p>
    </footer>
</div>
</div>

<!-- full skip link functionality in webkit browsers -->
<script src="${focusfixUrl}"></script>
</body>
</html>
