import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/step1")
    public ResponseEntity<Long> submitStep1(@RequestBody @Valid PersonalInfoDTO dto) {
        Student student = studentService.saveStep1(dto);
        return ResponseEntity.ok(student.getId());
    }

    @PostMapping("/step2/{studentId}")
    public ResponseEntity<?> submitStep2(@PathVariable Long studentId,
                                         @RequestBody @Valid NextOfKinDTO dto) {
        studentService.saveStep2(studentId, dto);
        return ResponseEntity.ok("Step 2 valid");
    }

    @PostMapping("/step3/{studentId}")
    public ResponseEntity<?> submitStep3(@PathVariable Long studentId,
                                         @RequestBody @Valid CourseSelectionDTO dto) {
        studentService.saveStep3(studentId, dto);
        return ResponseEntity.ok("Step 3 valid");
    }

    @PostMapping("/step4/{studentId}")
    public ResponseEntity<?> submitStep4(@PathVariable Long studentId,
                                         @RequestBody @Valid EducationBackgroundDTO dto) throws Exception {
        studentService.saveStep4(studentId, dto);
        return ResponseEntity.ok("Step 4 valid");
    }

    @PostMapping("/step5/{studentId}")
    public ResponseEntity<?> submitStep5(@PathVariable Long studentId,
                                         @RequestBody @Valid SponsorshipDTO dto) {
        studentService.saveStep5(studentId, dto);
        return ResponseEntity.ok("Step 5 valid");
    }

    @PostMapping("/step6/{studentId}")
    public ResponseEntity<?> submitStep6(@PathVariable Long studentId,
                                         @RequestBody @Valid DeclarationDTO dto) {
        studentService.saveStep6(studentId, dto);
        return ResponseEntity.ok("Application submitted successfully!");
    }
}
