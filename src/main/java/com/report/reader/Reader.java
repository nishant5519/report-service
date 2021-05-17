package com.report.reader;

import java.io.FileReader;
import java.util.List;

import com.report.model.Project;

public interface Reader {
  List<Project> read(FileReader file);
}