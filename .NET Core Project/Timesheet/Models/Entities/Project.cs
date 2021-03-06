﻿using System;
using System.Collections.Generic;
using System.Diagnostics.CodeAnalysis;
using System.Linq;
using System.Threading.Tasks;

namespace Timesheet.Models.Entities
{
    public class Project
    {
        public int Id { get; set; }

        [NotNull]
        public string Name { get; set; }

        public int DepartmentOwnerId { get; set; }
        public virtual Department DepartmentOwner { get; set; }

        public ICollection<DepartmentProject> Departments { get; set; }

    }
}
