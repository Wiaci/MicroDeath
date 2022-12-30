package wiaci.proj.facade.feignClient.fallback;

import wiaci.proj.facade.entity.Exam;
import wiaci.proj.facade.entity.Schedule;
import wiaci.proj.facade.feignClient.ExamScheduleClient;

import java.util.ArrayList;
import java.util.List;

public class ExamClientFallback implements ExamScheduleClient {
    @Override
    public Exam getExam(Long id) {
        return null;
    }

    @Override
    public List<Exam> getAllExams() {
        return new ArrayList<>();
    }

    @Override
    public Exam addExam(Exam exam) {
        return null;
    }

    @Override
    public void deleteExam(Long id) {}

    @Override
    public Schedule getSchedule(Long id) {
        return null;
    }

    @Override
    public List<Schedule> getAllSchedules() {
        return null;
    }

    @Override
    public Schedule addSchedule(Schedule schedule) {
        return null;
    }

    @Override
    public void deleteSchedule(Long id) {}
}
