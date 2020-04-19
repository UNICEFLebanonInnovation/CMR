package com.accessibilities.CMRAPP;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SurvivorYESActivity extends AppCompatActivity {

    private List<Cell> cells;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survivor_yes);

        rv=(RecyclerView)findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

    }

    private void initializeData() {
        cells = new ArrayList<>();
        SharedPreferences sharedPref = getSharedPreferences( getString(R.string.preference_lang_key), Context.MODE_PRIVATE);
        String lang = sharedPref.getString("lang", null);

        if ( lang.equals("ENG") ) {
            cells.add(new Cell(Cell.TEXT_TYPE, "Take to private consultation room", "Allow the patient to have a companion during the exam if she wishes Companion should be a trusted person by survivors and/or a case worker. Child survivors should be accompanied by Adults and/or case workers."));
            cells.add(new Cell(Cell.TEXT_TYPE, "Offer Comfort, understanding and encourage patient to express her/his feelings, fears and to ask questions.", "Survivors deserve respect and compassion. Never to be blamed for their attack. they often hide their experience out of fear and shame. Don't ask irrelevant questions to survivors (like cloth, relationship to rapist, details of the incident) Always remember our intervention is only Medical."));
            cells.add(new Cell(Cell.TEXT_TYPE, "Provide life-saving interventions, stabilization and pain control as necessary.", "Ask for permission before touching, and explain that you will stop upon request consent is the first step for survivors to regain control of their bodies."));
            cells.add(new Cell(Cell.HINT_TYPE, "Explain procedures and get informed consent.", "Survivors have a right to health-care, privacy, confidentiality, self-determination and information. Explain everything to to enable them to make an informal decision about whether or not she/he wants to be examined and treated.", "Medical consent form"));
            cells.add(new Cell(Cell.TEXT_TYPE, "Take medical history", "Medical Intake form"));
            cells.add(new Cell(Cell.HINT_TYPE, "Obtain Samples for forensic evidence", "A signed release is required before sharing details about the case with anyone outside the facility. Ensure informed consent is obtained on collecting forensic evidence from survivors. Explain to survivor that it is her decision to seek legal services obtaining forensic evidence doesn't mean she should or obliged to seek legal charges.", "Consent form"));
            cells.add(new Cell(Cell.TEXT_TYPE, "Treat or repair genital injuries as necessary", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "Counsel on possible health consequences", "The principle of informed consent applies to ALL, not just survivors of sexual assault."));
            cells.add(new Cell(Cell.TEXT_TYPE, "Follow protocols for diagnosis and treatment of STIs.", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "Give tetanus prophylaxis if indicated.", ""));
            cells.add(new Cell(Cell.TEXT_TYPE, "Give Hepatitis B Vaccine if available.", ""));
            cells.add(new Cell(Cell.YESNO_TYPE, "Was the incident within 72 -120 Hrs ?", "", "SurvivorYES_YESActivity", "SurvivorYES_NOActivity"));
        } else if ( lang.equals("ARB") ) {
            cells.add(new Cell(Cell.TEXT_TYPE,"قم باصطحاب المريضة إلى غرفة الفحص واحرص إن كانت لوحدها على وجود مرافقة معها خلال فترةالفحص", "السماح لمرافق)ة( موثوق أن يبقى معها طوال فترة الفحص. قد تحتاج أحدى الناجيات إلى الترجمة٬ ولكن ينبغى أيضاً أن يكونالمترجم شخص ترتاح له الناجية أيضا ويفهم كيفية. الحفاظ على السرية. اذا كان الناجي)ة( طفلا٬ لا بد من وجود احد أولياء امره ما لم يكن مشتبها به او موظف الرعايةالاجتماعية"));
            cells.add(new Cell(Cell.TEXT_TYPE,"اسأل الناجية إذا كان هناك اي شيء بإمكانك القيام به لجعلها تشعر بالراحة أكثر أو لمساعدتها على اتخاذ ترتيبات.", "وضع الناجية هو وضع صعب بغض النظر عن وقت حدوث الإساءة￼يجب تقديم الخدمة بطريقة متعاطفة والكفؤة والسرية دائما عرف عن نفسك واسأل الناجية عن اللغة التى تفضلها . لايجب ان نسأل الناجي )ة( اسئلة لاتمت بوضعها الصحي مثل ثيابها ٬علاقتها بالمعتدي اوتفاصيل عن الحادث علينا الانتباه ان تدخلنا يشمل فقط المساعدة الطبية."));
            cells.add(new Cell(Cell.TEXT_TYPE,"قم بتوفير التدخلات المنقذة للحياة و الاستقرار والتخفيف من الألم كما تقتضي الضرورة.", "حالة الاعتداء الجنسي حالة معقدة أكثر من أى حالة طبية أخرى فيجب كمقدم خدمة أن تكون صريحا مع الناجية تماما من حيث العلاج٬ الممكن تقديمه وكذلك العلاجات الوقائية التي ممكن تقديمها لها٬ بحيث تشعرالمريضة أنها هي صاحبة القرار! فهي من ستأخذ القرار سواء كانت تريد أخذ العلاج أو أي اجراء ثان مناسب في حالتها"));
            cells.add(new Cell(Cell.HINT_TYPE,"قم بتوفير التدخلات المنقذة للحياة و الاستقرار والتخفيف من الألم كما تقتضيالضرورة.", "حالة الاعتداء الجنسي حالة معقدة أكثر من أى حالة طبية أخرى.", "أخذ السيرة المريضة للناجية"));
            cells.add(new Cell(Cell.TEXT_TYPE,"أخذ السيرة المريضة للناجية", ""));
            cells.add(new Cell(Cell.HINT_TYPE,"احصل على عينات للادلة الجنائية", "يجب الحصول على تصريح خطي قبل إعطاء أيتفاصيل عن الحالة إلى أي شخص خارج العيادة. ", "أكد:ليس عليها أن تتخذ قرارا حول الادعاءأو عدم الادعاء على المعتدي فورا. عند جمع الأدلة عند أول معاينة فإنها بذلك تبقي خياراتها مفتوحة.يمكن اتلاف الأدلة لاحقا ان رغبت هي بذلك"));
            cells.add(new Cell(Cell.TEXT_TYPE,"عالج او ضمد الجروح التناسلية حسب الضرورة", ""));
            cells.add(new Cell(Cell.TEXT_TYPE,"تشاور حول العواقب الصحية الممكنة لما بعد التعرض للاغتصاب", "ينطبق مبدأ الموافقة المستنيرة على الجميع٬ ليس فقط على الناجيات من الاعتداء الجنسي."));
            cells.add(new Cell(Cell.TEXT_TYPE,"تتبع البروتوكولات الخاصة بالتشخيص ومعالجة الامراض المنقولة جنسيا.", ""));
            cells.add(new Cell(Cell.TEXT_TYPE,"اعطي علاج للكزاز اذا تم الاشارة لذلك.", ""));
            cells.add(new Cell(Cell.TEXT_TYPE,"اعطي لقاح الالتهاب الكبد الوبائي ب اذا كان متوافرا.", ""));
            cells.add(new Cell(Cell.YESNO_TYPE,"خلال ۷۲-۱۲۰ ساعة?", "", "SurvivorYES_YESActivity", "SurvivorYES_NOActivity"));
        }
    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(cells);
        rv.setAdapter(adapter);
    }

}
